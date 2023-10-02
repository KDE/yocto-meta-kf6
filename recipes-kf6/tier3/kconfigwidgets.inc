# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.1-only"
PR = "r0"

DEPENDS = "qtbase \
    kauth \
    kauth-native \
    kcoreaddons \
    kcoreaddons-native \
    kcodecs \
    kcolorscheme \
    kconfig \
    kconfig-native \
    kguiaddons \
    kwidgetsaddons \
"

require kconfigwidgets_metainfo.inc
inherit kf6-cmake
inherit kf6-ki18n
inherit reuse_license_checksums

FILES:${PN}-dev += " \
    ${bindir}/preparetips5 \
"

RDEPENDS:${PN}-dev += "perl"
