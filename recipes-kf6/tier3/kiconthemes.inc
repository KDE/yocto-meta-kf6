# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.1-only"
PR = "r0"

DEPENDS = "qtbase \
    qtsvg \
    karchive \
    kcoreaddons \
    kcoreaddons-native \
    kconfigwidgets \
    kconfig-native \
    kauth-native \
    kwidgetsaddons \
"

require kiconthemes_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-ki18n
inherit reuse_license_checksums

FILES:${PN} += "\
    ${libdir}/plugins/iconengines/ \
    ${libdir}/qml/org/kde/iconthemes/* \
"
