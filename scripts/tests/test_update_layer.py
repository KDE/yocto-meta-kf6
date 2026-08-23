# SPDX-FileCopyrightText: 2026 Marc Ferland <marc.ferland@gmail.com>
#
# SPDX-License-Identifier: MIT

from __future__ import annotations

import importlib.util
import io
import sys
import tempfile
import unittest
from pathlib import Path
from unittest import mock


SCRIPT = Path(__file__).parents[1] / "update_layer.py"
SPEC = importlib.util.spec_from_file_location("update_layer", SCRIPT)
assert SPEC and SPEC.loader
update_layer = importlib.util.module_from_spec(SPEC)
sys.modules[SPEC.name] = update_layer
SPEC.loader.exec_module(update_layer)


OLD_CHECKSUM = "1" * 64
NEW_CHECKSUM = "2" * 64


class UpdateLayerTests(unittest.TestCase):
    def setUp(self) -> None:
        self.temporary = tempfile.TemporaryDirectory()
        self.root = Path(self.temporary.name)
        (self.root / "recipes-kf6/tier1").mkdir(parents=True)
        (self.root / "recipes-kdesupport").mkdir()
        (self.root / "recipes-kf6/frameworks_src.inc").write_text(
            f'SRC_URI_SHA256SUM_attica = "{OLD_CHECKSUM}"\n', encoding="utf-8"
        )
        (self.root / "recipes-kdesupport/application_src.inc").write_text(
            f'SRC_URI_SHA256SUM_baloo-widgets = "{OLD_CHECKSUM}"\n', encoding="utf-8"
        )
        (self.root / "recipes-kf6/tier1/attica_6.25.0.bb").write_text(
            "SUMMARY = \"Attica\"\n"
            "require recipes-kf6/frameworks_src.inc\n"
            "inherit kf6_cmake_framework\n",
            encoding="utf-8",
        )
        (self.root / "recipes-kdesupport/baloo-widgets_25.12.1.bb").write_text(
            "SUMMARY = \"Baloo Widgets\"\n"
            "require recipes-kdesupport/application_src.inc\n",
            encoding="utf-8",
        )

    def tearDown(self) -> None:
        self.temporary.cleanup()

    @staticmethod
    def checksums(updates):
        return {update.archive_url: NEW_CHECKSUM for update in updates}

    def test_framework_normalizes_version_and_updates_checksum(self) -> None:
        updates = update_layer.execute(
            self.root,
            [update_layer.Release("framework", update_layer.normalize_framework_version("6.18"))],
            self.checksums,
        )
        destination = self.root / "recipes-kf6/tier1/attica_6.18.0.bb"
        self.assertTrue(destination.is_file())
        self.assertFalse((self.root / "recipes-kf6/tier1/attica_6.25.0.bb").exists())
        self.assertIn(
            NEW_CHECKSUM,
            (self.root / "recipes-kf6/frameworks_src.inc").read_text(),
        )
        self.assertEqual(
            updates[0].archive_url,
            "https://download.kde.org/stable/frameworks/6.18/attica-6.18.0.tar.xz",
        )

    def test_all_updates_both_families(self) -> None:
        update_layer.execute(
            self.root,
            [update_layer.Release("framework", "6.18.0"), update_layer.Release("gear", "26.04.2")],
            self.checksums,
        )
        self.assertTrue((self.root / "recipes-kf6/tier1/attica_6.18.0.bb").is_file())
        self.assertTrue(
            (self.root / "recipes-kdesupport/baloo-widgets_26.04.2.bb").is_file()
        )
        self.assertIn(
            NEW_CHECKSUM,
            (self.root / "recipes-kdesupport/application_src.inc").read_text(),
        )

    def test_same_version_is_idempotent(self) -> None:
        update_layer.execute(
            self.root, [update_layer.Release("framework", "6.25.0")], self.checksums
        )
        self.assertTrue((self.root / "recipes-kf6/tier1/attica_6.25.0.bb").is_file())
        self.assertEqual(
            len(list((self.root / "recipes-kf6/tier1").glob("attica_*.bb"))), 1
        )

    def test_checksum_response_filename_is_validated(self) -> None:
        class Response(io.BytesIO):
            def __enter__(self):
                return self

            def __exit__(self, *_args):
                self.close()

        def opener(_request, timeout):
            self.assertEqual(timeout, 30)
            return Response(f"{NEW_CHECKSUM} wrong-name.tar.xz".encode())

        with self.assertRaises(update_layer.UpdateError):
            update_layer.fetch_checksum(
                "https://example.invalid/attica-6.18.0.tar.xz", opener=opener
            )

    def test_urlopen_retries_temporary_http_errors(self) -> None:
        class Response(io.BytesIO):
            def __enter__(self):
                return self

            def __exit__(self, *_args):
                self.close()

        http_error = update_layer.urllib.error.HTTPError(
            "https://example.invalid", 503, "unavailable", {}, io.BytesIO()
        )
        responses = iter([http_error, Response(b"checksum response")])

        def opener(_url, timeout):
            self.assertEqual(timeout, 30)
            response = next(responses)
            if isinstance(response, Exception):
                raise response
            return response

        try:
            with mock.patch.object(update_layer.time, "sleep") as sleep:
                with mock.patch("builtins.print"):
                    result = update_layer.urlopen_with_retry(
                        "https://example.invalid", opener=opener
                    )
        finally:
            http_error.close()

        self.assertEqual(result, "checksum response")
        sleep.assert_called_once_with(1)

    def test_urlopen_does_not_retry_fatal_http_errors(self) -> None:
        http_error = update_layer.urllib.error.HTTPError(
            "https://example.invalid", 404, "not found", {}, io.BytesIO()
        )

        def opener(url, timeout):
            self.assertEqual(timeout, 30)
            self.assertEqual(url, http_error.url)
            raise http_error

        try:
            with mock.patch.object(update_layer.time, "sleep") as sleep:
                with self.assertRaises(update_layer.UpdateError):
                    update_layer.urlopen_with_retry(
                        "https://example.invalid", opener=opener
                    )
        finally:
            http_error.close()

        sleep.assert_not_called()

    def test_fetch_failure_does_not_modify_files(self) -> None:
        original_recipe = self.root / "recipes-kf6/tier1/attica_6.25.0.bb"
        original_include = (self.root / "recipes-kf6/frameworks_src.inc").read_text()

        def fail(_updates):
            raise update_layer.UpdateError("unavailable")

        with self.assertRaises(update_layer.UpdateError):
            update_layer.execute(
                self.root, [update_layer.Release("framework", "6.18.0")], fail
            )
        self.assertTrue(original_recipe.is_file())
        self.assertEqual(
            original_include,
            (self.root / "recipes-kf6/frameworks_src.inc").read_text(),
        )

    def test_destination_collision_does_not_modify_files(self) -> None:
        collision = self.root / "recipes-kf6/tier1/attica_6.18.0.bb"
        collision.write_text("collision\n", encoding="utf-8")
        with self.assertRaises(update_layer.UpdateError):
            update_layer.execute(
                self.root, [update_layer.Release("framework", "6.18.0")], self.checksums
            )
        self.assertEqual(collision.read_text(), "collision\n")
        self.assertIn(
            OLD_CHECKSUM,
            (self.root / "recipes-kf6/frameworks_src.inc").read_text(),
        )

    def test_invalid_versions_are_rejected(self) -> None:
        with self.assertRaises(Exception):
            update_layer.normalize_framework_version("6")
        with self.assertRaises(Exception):
            update_layer.normalize_gear_version("26.04")


if __name__ == "__main__":
    unittest.main()
