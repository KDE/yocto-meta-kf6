# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020-2026 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KIconThemes"
DESCRIPTION = "Icon GUI utilities"
HOMEPAGE = "https://invent.kde.org/frameworks/kiconthemes"
LICENSE = "LGPL-2.1-only"

DEPENDS += "breeze-icons \
            karchive \
            kauth-native \
            kcolorscheme \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kwidgetsaddons \
            qtbase \
            qtbase-native \
            qtsvg \
"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/plugins/iconengines/ \
                ${libdir}/plugins/kiconthemes6/iconengines/KIconEnginePlugin.so \
                ${libdir}/qml/org/kde/iconthemes/* \
"
