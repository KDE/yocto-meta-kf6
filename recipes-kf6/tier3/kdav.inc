# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-or-later"
PR = "r0"

DEPENDS = " \
    qtbase \
    kio \
    kcoreaddons \
    kcoreaddons-native \
    kdoctools \
    ki18n \
"

require kdav_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-kdoctools
inherit kf6-kconfig
inherit kf6-kauth
inherit reuse_license_checksums
