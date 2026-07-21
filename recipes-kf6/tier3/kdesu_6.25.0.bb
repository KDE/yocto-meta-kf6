# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KDE Su"
DESCRIPTION = "User interface for running shell commands with root privileges"
HOMEPAGE = "https://invent.kde.org/frameworks/kdesu"
LICENSE = "LGPL-2.1-only"

DEPENDS += "kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kpty \
            qtbase \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums
