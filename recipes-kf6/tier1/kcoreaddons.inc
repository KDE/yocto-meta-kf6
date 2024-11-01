# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

REUSE_LICENSECHECK_WHITELIST = "CC0-1.0"
LICENSE = "LGPL-2.1-only"
PR = "r0"

DEPENDS = "qtbase kcoreaddons-native"

require kcoreaddons_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums
inherit mime-xdg
inherit mime

SRC_URI:append = " file://0001-Fix-absolute-path-generation-into-not-installed-head.patch"

FILES:${PN} += " \
    ${datadir}/mime/packages/kde5.xml \
    ${datadir}/kf6/licenses/* \
    ${datadir}/kf6/jsonschema/* \
    ${libdir}/qml/org/kde/coreaddons/* \
"

FILES:${PN}-dev += " \
    ${bindir}/desktoptojson \
"
