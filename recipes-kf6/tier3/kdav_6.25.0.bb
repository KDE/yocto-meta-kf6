# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KDav"
DESCRIPTION = "This is an DAV protocol implementation with KJobs"
HOMEPAGE = "https://invent.kde.org/frameworks/kdav"
LICENSE = "LGPL-2.0-or-later"

DEPENDS += "kcoreaddons \
            kcoreaddons-native \
            ki18n \
            kio \
            qtbase \
"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_kdoctools
inherit kf6_kconfig
inherit kf6_kauth
inherit reuse_license_checksums
