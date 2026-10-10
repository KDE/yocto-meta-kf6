# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KWindowSystem"
DESCRIPTION = "Access to the windowing system"
HOMEPAGE = "https://invent.kde.org/frameworks/kwindowsystem/"
LICENSE = "MIT & BSD-3-Clause & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

DEPENDS += "plasma-wayland-protocols \
            qtbase \
            qtwayland \
            qtwayland-native \
"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/plugins/kf6/org.kde.kwindowsystem.platforms/* \
                ${libdir}/plugins/kf6/kwindowsystem/* \
                ${libdir}/qml/org/kde/kwindowsystem/* \
"
