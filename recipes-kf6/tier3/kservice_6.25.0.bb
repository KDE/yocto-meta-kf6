# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KService"
DESCRIPTION = "KService allows to query information about installed applications and their associated file types"
HOMEPAGE = "https://invent.kde.org/frameworks/kservice"
LICENSE = "LGPL-2.1-only"

DEPENDS += "kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kdbusaddons \
            qtbase \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums
