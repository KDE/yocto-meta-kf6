# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KCoreAddons"
DESCRIPTION = "Qt addon library with a collection of non-GUI utilities"
HOMEPAGE = "https://invent.kde.org/frameworks/kcoreaddons"
REUSE_LICENSECHECK_WHITELIST = "CC0-1.0"
LICENSE = "LGPL-2.1-only"

DEPENDS += "kcoreaddons-native qtbase"

inherit kf6_src
inherit kf6_cmake_framework
inherit reuse_license_checksums
inherit mime

FILES:${PN} += "${datadir}/mime/packages/kde5.xml \
                ${datadir}/kf6/licenses/* \
                ${datadir}/kf6/jsonschema/* \
                ${libdir}/qml/org/kde/coreaddons/* \
"

FILES:${PN}-dev += "${bindir}/desktoptojson"

EXTRA_OECMAKE += "-DBUILD_PYTHON_BINDINGS=OFF"
