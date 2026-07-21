# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KPty"
DESCRIPTION = "Interfacing with pseudo terminal devices"
HOMEPAGE = "https://invent.kde.org/frameworks/kpty"
LICENSE = "LGPL-2.0-or-later & BSD-3-Clause"

DEPENDS += "kcoreaddons kcoreaddons-native"

EXTRA_OECMAKE += "-DCMAKE_DISABLE_FIND_PACKAGE_UTEMPTER=ON"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums
