# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KConfigWidgets"
DESCRIPTION = "Widgets for configuration dialogs"
HOMEPAGE = "https://invent.kde.org/frameworks/kconfigwidgets"
LICENSE = "LGPL-2.1-only"

DEPENDS += "kauth \
            kauth-native \
            kcodecs \
            kcolorscheme \
            kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kguiaddons \
            kwidgetsaddons \
            qtbase \
"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

FILES:${PN}-dev += "${bindir}/preparetips5"

RDEPENDS:${PN}-dev += "perl"
