# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KTextWidgets"
DESCRIPTION = "Text editing widgets"
HOMEPAGE = "https://invent.kde.org/frameworks/ktextwidgets"
LICENSE = "LGPL-2.1-or-later & (LGPL-2.0-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

DEPENDS += "kauth-native \
            kcompletion \
            kconfig \
            kconfig-native \
            kcoreaddons-native \
            kservice \
            kwidgetsaddons \
            qtbase \
            qtspeech \
            sonnet \
"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums
