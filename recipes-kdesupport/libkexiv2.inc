# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
# SPDX-FileCopyrightText: 2024 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Wrapper around Exiv2 library to manipulate picture metadata as EXIF and XMP"
SUMMARY = "Wrapper around Exiv2 library to manipulate picture metadata as EXIF and XMP"
HOMEPAGE = "https://invent.kde.org/graphics/libkexiv2"
LICENSE = "BSD-3-Clause & GPL-2.0-or-later"


inherit kf6-cmake-framework
inherit reuse_license_checksums

DEPENDS = " \
    exiv2 \
    qtbase \
"
