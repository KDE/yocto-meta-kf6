# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "MIT & BSD-3-Clause & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtwayland \
    qtwayland-native \
    plasma-wayland-protocols \
"

require kwindowsystem_metainfo.inc
inherit kf6-cmake
inherit cmake_sysroot
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/plugins/kf6/org.kde.kwindowsystem.platforms/* \
    ${libdir}/plugins/kf6/kwindowsystem/* \
    ${libdir}/qml/org/kde/kwindowsystem/* \
"
