# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-or-later & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"
PR = "r0"

# licenses only contained in autotests
REUSE_LICENSECHECK_WHITELIST = "GPL-2.0-only GPL-3.0-only LicenseRef-KDE-Accepted-GPL"

DEPENDS = " \
    qtbase \
    qtwayland \
    qtwayland-native \
    wayland-protocols \
    plasma-wayland-protocols \
"

require kguiaddons_metainfo.inc
inherit kf6-cmake-framework
inherit mime-xdg
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/plugins/kf6/kguiaddons/kmodifierkey/ \
"
