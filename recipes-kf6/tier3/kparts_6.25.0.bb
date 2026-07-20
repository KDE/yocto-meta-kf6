# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018-2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KParts"
DESCRIPTION = "Plugin framework for user interface components"
HOMEPAGE = "https://invent.kde.org/frameworks/kparts"
LICENSE = "LGPL-2.0-or-later & LGPL-2.1-or-later"

DEPENDS += "kauth-native \
            kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kiconthemes \
            kio \
            kjobwidgets \
            kservice \
            ktextwidgets \
            kwidgetsaddons \
            kxmlgui \
            libxml2-native \
            qtbase \
"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums
