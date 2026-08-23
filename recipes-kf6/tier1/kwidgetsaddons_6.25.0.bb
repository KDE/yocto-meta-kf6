# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KWidgetsAddons"
DESCRIPTION = "Large set of desktop widgets"
HOMEPAGE = "https://invent.kde.org/frameworks/kwidgetsaddons"
LICENSE = "LGPL-2.0-or-later & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

DEPENDS += "qtbase"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums

PACKAGES += "${PN}-data"

FILES:${PN}-data += "${datadir}/kf6/kcharselect/kcharselect-data"

RRECOMMENDS:${PN} += "${PN}-data"

EXTRA_OECMAKE += "-DBUILD_PYTHON_BINDINGS=OFF"
