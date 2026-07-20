# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

# GPL-2.0+ only used in exmaple and test code

SUMMARY = "KIdleTime"
DESCRIPTION = "Reporting of idle time of user and system"
HOMEPAGE = "https://invent.kde.org/frameworks/kidletime"
REUSE_LICENSECHECK_WHITELIST = "GPL-2.0-or-later"
LICENSE = "LGPL-2.1-or-later & MIT"

DEPENDS += "plasma-wayland-protocols \
            qtbase \
            qtwayland \
            qtwayland-native \
"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/plugins/kf6/org.kde.kidletime.platforms/*.so"
