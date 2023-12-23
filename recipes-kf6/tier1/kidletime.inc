# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

# GPL-2.0+ only used in exmaple and test code
REUSE_LICENSECHECK_WHITELIST = "GPL-2.0-or-later"
LICENSE = "LGPL-2.1-or-later & MIT"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtwayland \
    qtwayland-native \
    plasma-wayland-protocols \
"

require kidletime_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/plugins/kf6/org.kde.kidletime.platforms/*.so \
"
