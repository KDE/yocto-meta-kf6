# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018-2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0+ & LGPL-2.1"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtdeclarative \
    libxml2-native \
    kconfig \
    kconfig-native \
    kcoreaddons \
    kcoreaddons-native \
    kio \
    kauth-native \
    kitemmodels \
    kservice \
    plasma-framework \
    kpackage-native \
    solid \
    threadweaver \
"

require krunner_metainfo.inc
inherit cmake_kf6
inherit ki18n
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/qml/org/kde/krunner/* \
"
