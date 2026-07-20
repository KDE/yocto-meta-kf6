# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018-2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KNotifyConfig"
DESCRIPTION = "Configuration dialog for desktop notifications"
HOMEPAGE = "https://invent.kde.org/frameworks/knotifyconfig"
LICENSE = "LGPL-2.0-only"

DEPENDS += "kauth-native \
            kcompletion \
            kconfig \
            kconfig-native \
            kcoreaddons-native \
            kio \
            libxml2-native \
            qtbase \
"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums
