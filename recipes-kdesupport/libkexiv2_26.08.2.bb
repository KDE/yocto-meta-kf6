# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
# SPDX-FileCopyrightText: 2024 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

SUMMARY = "EXIV2 library interface for KDE"
DESCRIPTION = "Wrapper around Exiv2 library to manipulate picture metadata as EXIF and XMP"
HOMEPAGE = "https://invent.kde.org/graphics/libkexiv2"
LICENSE = "BSD-3-Clause & GPL-2.0-or-later"

require recipes-kdesupport/application_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums

DEPENDS += "exiv2 qtbase"
