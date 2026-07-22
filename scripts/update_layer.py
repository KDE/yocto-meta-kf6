#!/usr/bin/env python3

# SPDX-FileCopyrightText: 2026 Marc Ferland <marc.ferland@gmail.com>
#
# SPDX-License-Identifier: MIT

"""Update KDE Frameworks and KDE Gear recipes and checksums.

Run all unit tests:
    python3 -m unittest discover -s scripts/tests -v

Run one unit test:
    python3 scripts/tests/test_update_layer.py \
        UpdateLayerTests.test_framework_normalizes_version_and_updates_checksum -v

Check Python syntax:
    python3 -m py_compile scripts/update_layer.py scripts/tests/test_update_layer.py
"""

from __future__ import annotations

import argparse
import concurrent.futures
import re
import sys
import time
import urllib.error
import urllib.request
from dataclasses import dataclass
from pathlib import Path
from typing import Callable, Iterable


FRAMEWORK_VERSION_RE = re.compile(r"^\d+\.\d+(?:\.\d+)?$")
GEAR_VERSION_RE = re.compile(r"^\d+\.\d+\.\d+$")
RECIPE_RE = re.compile(r"^(?P<name>.+)_(?P<version>\d+(?:\.\d+)+)\.bb$")
CHECKSUM_RE = re.compile(r"^[0-9a-f]{64}$")
RETRYABLE_HTTP_CODES = {429, 500, 502, 503, 504}


class UpdateError(RuntimeError):
    """A user-facing update failure."""


@dataclass(frozen=True)
class Release:
    name: str
    version: str


@dataclass(frozen=True)
class Family:
    name: str
    inherit_class: str
    metadata_class: str

    def archive_url(self, module: str, version: str) -> str:
        """Build the release archive URL for one module.

        Args:
            module: Module and archive base name.
            version: Full release version used in the archive filename.

        Returns:
            The HTTPS URL of the release archive.
        """
        if self.name == "framework":
            release_directory = ".".join(version.split(".")[:2])
            return (
                "https://download.kde.org/stable/frameworks/"
                f"{release_directory}/{module}-{version}.tar.xz"
            )
        return (
            "https://download.kde.org/stable/release-service/"
            f"{version}/src/{module}-{version}.tar.xz"
        )


@dataclass(frozen=True)
class RecipeUpdate:
    family: Family
    source: Path
    destination: Path
    module: str
    archive_url: str


FAMILIES = {
    "framework": Family("framework", "kf6_src", "classes/kf6_src.bbclass"),
    "gear": Family("gear", "kf6_kdegear_src", "classes/kf6_kdegear_src.bbclass"),
}


def normalize_framework_version(value: str) -> str:
    """Validate and normalize a KDE Frameworks version.

    Args:
        value: Version in X.Y or X.Y.Z form.

    Returns:
        The version normalized to X.Y.Z form.

    Raises:
        argparse.ArgumentTypeError: If the version has an unsupported format.
    """
    if not FRAMEWORK_VERSION_RE.fullmatch(value):
        raise argparse.ArgumentTypeError("expected X.Y or X.Y.Z")

    return value if value.count(".") == 2 else f"{value}.0"


def normalize_gear_version(value: str) -> str:
    """Validate a KDE Gear version.

    Args:
        value: Version in X.Y.Z form.

    Returns:
        The validated version unchanged.

    Raises:
        argparse.ArgumentTypeError: If the version has an unsupported format.
    """
    if not GEAR_VERSION_RE.fullmatch(value):
        raise argparse.ArgumentTypeError("expected X.Y.Z")

    return value


def build_parser() -> argparse.ArgumentParser:
    """Build the command-line parser and its release subcommands.

    Returns:
        The configured argument parser.
    """
    parser = argparse.ArgumentParser(
        description="Update KDE Frameworks and KDE Gear recipes and checksums."
    )
    subparsers = parser.add_subparsers(dest="command", required=True)

    framework = subparsers.add_parser("framework", help="update KDE Frameworks")
    framework.add_argument("version", type=normalize_framework_version)

    gear = subparsers.add_parser("gear", help="update KDE Gear")
    gear.add_argument("version", type=normalize_gear_version)

    all_releases = subparsers.add_parser("all", help="update both release families")
    all_releases.add_argument("framework_version", type=normalize_framework_version)
    all_releases.add_argument("gear_version", type=normalize_gear_version)
    return parser


def releases_from_args(args: argparse.Namespace) -> list[Release]:
    """Convert parsed command-line arguments into release requests.

    Args:
        args: Arguments produced by the command-line parser.

    Returns:
        One or two release requests selected by the subcommand.
    """
    if args.command == "all":
        return [
            Release("framework", args.framework_version),
            Release("gear", args.gear_version),
        ]

    return [Release(args.command, args.version)]


def inherits_class(recipe_text: str, class_name: str) -> bool:
    """Check whether a recipe directly inherits a BitBake class.

    Args:
        recipe_text: Complete recipe contents.
        class_name: BitBake class name to find.

    Returns:
        True when an inherit statement contains the class.
    """
    return any(
        class_name in match.group(1).split()
        for match in re.finditer(r"^\s*inherit\s+(.+)$", recipe_text, re.MULTILINE)
    )


def discover_updates(root: Path, release: Release) -> list[RecipeUpdate]:
    """Discover recipes belonging to a release and plan their updates.

    Args:
        root: Layer repository root.
        release: Release family and target version.

    Returns:
        Planned recipe renames and archive URLs.

    Raises:
        UpdateError: If recipes are missing, malformed, or would be overwritten.
    """
    family = FAMILIES[release.name]
    updates: list[RecipeUpdate] = []

    for recipe in sorted(root.glob("recipes-*/**/*.bb")):
        text = recipe.read_text(encoding="utf-8")
        if not inherits_class(text, family.inherit_class):
            continue

        match = RECIPE_RE.fullmatch(recipe.name)
        if not match:
            raise UpdateError(f"versioned recipe name expected: {recipe.relative_to(root)}")

        name = match.group("name")
        destination = recipe.with_name(f"{name}_{release.version}.bb")
        if destination != recipe and destination.exists():
            raise UpdateError(f"destination already exists: {destination.relative_to(root)}")

        archive_url = family.archive_url(name, release.version)
        updates.append(RecipeUpdate(family, recipe, destination, name, archive_url))

    if not updates:
        raise UpdateError(f"no recipes inheriting {family.inherit_class} were found")

    return updates


def group_by_family(
    updates: Iterable[RecipeUpdate],
) -> dict[Family, list[RecipeUpdate]]:
    """Group planned recipe updates by release family.

    Args:
        updates: Planned recipe updates.

    Returns:
        Updates keyed by their Frameworks or Gear family.
    """
    grouped: dict[Family, list[RecipeUpdate]] = {}
    for update in updates:
        grouped.setdefault(update.family, []).append(update)

    return grouped


def validate_metadata(root: Path, updates: Iterable[RecipeUpdate]) -> None:
    """Validate centralized checksum metadata for planned updates.

    Args:
        root: Layer repository root.
        updates: Planned recipe updates to validate.

    Raises:
        UpdateError: If a class or checksum assignment is missing or duplicated.
    """
    for family, family_updates in group_by_family(updates).items():
        metadata_path = root / family.metadata_class
        if not metadata_path.is_file():
            raise UpdateError(f"metadata class not found: {family.metadata_class}")

        metadata = metadata_path.read_text(encoding="utf-8")

        for update in family_updates:
            assignment = re.compile(
                rf'^SRC_URI_SHA256SUM_{re.escape(update.module)} = "([0-9a-f]{{64}})"$',
                re.MULTILINE,
            )
            count = len(assignment.findall(metadata))

            if count != 1:
                raise UpdateError(
                    f"expected one checksum assignment for {update.module} in "
                    f"{family.metadata_class}, found {count}"
                )


def urlopen_with_retry(
    url: str,
    opener=urllib.request.urlopen,
    max_retries: int = 3,
    backoff_factor: int = 2,
) -> str:
    """Download text from a URL with retries for temporary failures.

    Args:
        url: URL to download.
        opener: URL-opening callable, injectable for tests.
        max_retries: Maximum number of network attempts.
        backoff_factor: Multiplier applied to the delay after each retry.

    Returns:
        The decoded UTF-8 response body.

    Raises:
        UpdateError: If the request fails or exhausts all retries.
    """
    delay = 1
    last_error: urllib.error.HTTPError | urllib.error.URLError | None = None

    for attempt in range(1, max_retries + 1):
        try:
            with opener(url, timeout=30) as response:
                return response.read().decode("utf-8")
        except urllib.error.HTTPError as error:
            if error.code not in RETRYABLE_HTTP_CODES:
                raise UpdateError(f"HTTP error {error.code} while fetching {url}") from error
            last_error = error
        except urllib.error.URLError as error:
            last_error = error

        if attempt < max_retries:
            print(f"retrying {url} after attempt {attempt}/{max_retries}", file=sys.stderr)
            time.sleep(delay)
            delay *= backoff_factor

    raise UpdateError(f"unable to fetch {url}: {last_error}")


def fetch_checksum(
    archive_url: str,
    opener=urllib.request.urlopen,
) -> str:
    """Download and validate one archive checksum sidecar.

    Args:
        archive_url: URL of the release archive.
        opener: URL-opening callable, injectable for tests.

    Returns:
        The validated lowercase SHA-256 checksum.

    Raises:
        UpdateError: If the response is unavailable or malformed.
    """
    checksum_url = f"{archive_url}.sha256"
    expected_filename = archive_url.rsplit("/", 1)[1]
    fields = urlopen_with_retry(checksum_url, opener=opener).split()

    if len(fields) != 2:
        raise UpdateError(f"malformed checksum response from {checksum_url}")

    checksum, filename = fields
    if not CHECKSUM_RE.fullmatch(checksum):
        raise UpdateError(f"invalid SHA-256 checksum from {checksum_url}")

    if filename != expected_filename:
        raise UpdateError(f"checksum filename mismatch from {checksum_url}: {filename}")

    return checksum


def fetch_checksums(updates: Iterable[RecipeUpdate]) -> dict[str, str]:
    """Fetch all required checksums concurrently.

    Args:
        updates: Planned recipe updates containing archive URLs.

    Returns:
        Checksums keyed by archive URL.

    Raises:
        UpdateError: If one or more checksum downloads fail.
    """
    urls = sorted({update.archive_url for update in updates})
    checksums: dict[str, str] = {}
    errors: list[str] = []

    with concurrent.futures.ThreadPoolExecutor(max_workers=8) as executor:
        future_urls = {executor.submit(fetch_checksum, url): url for url in urls}
        for future in concurrent.futures.as_completed(future_urls):
            url = future_urls[future]
            try:
                checksums[url] = future.result()
            except UpdateError as error:
                errors.append(str(error))

    if errors:
        raise UpdateError("checksum download failed:\n  " + "\n  ".join(sorted(errors)))

    return checksums


def updated_metadata(
    root: Path, updates: Iterable[RecipeUpdate], checksums: dict[str, str]
) -> dict[Path, str]:
    """Prepare updated class contents without modifying files.

    Args:
        root: Layer repository root.
        updates: Planned recipe updates.
        checksums: Downloaded checksums keyed by archive URL.

    Returns:
        New class contents keyed by metadata path.

    Raises:
        UpdateError: If a checksum assignment cannot be replaced exactly once.
    """
    result: dict[Path, str] = {}
    for family, family_updates in group_by_family(updates).items():
        path = root / family.metadata_class
        text = path.read_text(encoding="utf-8")

        for update in family_updates:
            assignment = re.compile(
                rf'^(SRC_URI_SHA256SUM_{re.escape(update.module)} = ")[0-9a-f]{{64}}("$)',
                re.MULTILINE,
            )
            text, count = assignment.subn(
                rf"\g<1>{checksums[update.archive_url]}\g<2>", text
            )

            if count != 1:
                raise UpdateError(f"failed to update checksum for {update.module}")

        result[path] = text

    return result


def apply_updates(
    updates: list[RecipeUpdate],
    metadata: dict[Path, str],
) -> None:
    """Write prepared class metadata and rename versioned recipes.

    Args:
        updates: Validated recipe updates to apply.
        metadata: Prepared class contents keyed by destination path.
    """
    for path, content in metadata.items():
        path.write_text(content, encoding="utf-8")

    for update in updates:
        if update.source != update.destination:
            update.source.rename(update.destination)


def execute(
    root: Path,
    releases: Iterable[Release],
    checksum_fetcher: Callable[[Iterable[RecipeUpdate]], dict[str, str]] = fetch_checksums,
) -> list[RecipeUpdate]:
    """Validate, download, prepare, and apply release updates.

    Args:
        root: Layer repository root.
        releases: Requested release families and versions.
        checksum_fetcher: Checksum provider, injectable for tests.

    Returns:
        The recipe updates that were applied.

    Raises:
        UpdateError: If discovery, validation, or checksum retrieval fails.
    """
    updates: list[RecipeUpdate] = []
    for release in releases:
        updates.extend(discover_updates(root, release))

    validate_metadata(root, updates)
    checksums = checksum_fetcher(updates)
    metadata = updated_metadata(root, updates, checksums)

    apply_updates(updates, metadata)

    return updates


def main(argv: list[str] | None = None) -> int:
    """Run the command-line updater and report results.

    Args:
        argv: Optional argument list; defaults to process arguments.

    Returns:
        Zero on success or one for an update failure.
    """
    args = build_parser().parse_args(argv)
    root = Path(__file__).resolve().parent.parent

    try:
        updates = execute(root, releases_from_args(args))
    except UpdateError as error:
        print(f"error: {error}", file=sys.stderr)
        return 1

    for update in updates:
        if update.source != update.destination:
            print(f"rename {update.source.relative_to(root)} -> {update.destination.name}")
        print(f"checksum {update.module}: {update.archive_url}")

    print(f"updated {len(updates)} recipes; changes were left unstaged")

    return 0


if __name__ == "__main__":
    raise SystemExit(main())
