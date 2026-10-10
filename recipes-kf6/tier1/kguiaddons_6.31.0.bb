# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KGuiAddons"
DESCRIPTION = "Utilities for graphical user interfaces"
HOMEPAGE = "https://invent.kde.org/frameworks/kguiaddons"
LICENSE = "LGPL-2.0-or-later & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

# licenses only contained in autotests
REUSE_LICENSECHECK_WHITELIST = "GPL-2.0-only GPL-3.0-only LicenseRef-KDE-Accepted-GPL"

DEPENDS += "plasma-wayland-protocols \
            qtbase \
            qtwayland \
            qtwayland-native \
            wayland-protocols \
"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/plugins/kf6/kguiaddons/kmodifierkey/"

EXTRA_OECMAKE += "-DBUILD_PYTHON_BINDINGS=OFF"
