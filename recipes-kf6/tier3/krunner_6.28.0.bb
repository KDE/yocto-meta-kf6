# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018-2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KRunner"
DESCRIPTION = "Framework for Plasma runners"
HOMEPAGE = "https://invent.kde.org/frameworks/krunner"
LICENSE = "LGPL-2.0-or-later & LGPL-2.1-only"

DEPENDS += "kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kitemmodels \
            kwindowsystem \
            libxml2-native \
            qtbase \
"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/qml/org/kde/krunner/*"
