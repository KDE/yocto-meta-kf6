# SPDX-FileCopyrightText: 2024 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KMime"
DESCRIPTION = "Library to assist handling MIME data"
HOMEPAGE = "https://invent.kde.org/frameworks/kmime"
LICENSE = "BSD-3-Clause & LGPL-2.0-only & LGPL-2.0-or-later"

DEPENDS += "kcodecs qtbase"

inherit kf6_cmake_framework
inherit reuse_license_checksums
require recipes-kf6/frameworks_src.inc
