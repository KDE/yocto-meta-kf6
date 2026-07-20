# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KDNSSD Framework"
DESCRIPTION = "Network service discovery using Zeroconf"
HOMEPAGE = "https://invent.kde.org/frameworks/kdnssd"
LICENSE = "LGPL-2.0-or-later & BSD-3-Clause"

DEPENDS += "avahi qtbase"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums
