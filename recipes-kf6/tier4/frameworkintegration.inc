# SPDX-FileCopyrightText: 2018-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-only"
PR = "r0"

DEPENDS = " \
    qtbase \
    kconfig \
    kconfig-native \
    kconfigwidgets \
    kcoreaddons-native \
    kauth-native \
    kiconthemes \
    knotifications \
    kwidgetsaddons \
    kpackage \
    kpackage-native \
    knewstuff \
"

require frameworkintegration_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-ki18n
inherit kf6-kdoctools
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/plugins/kf6/FrameworkIntegrationPlugin.so \
    ${datadir}/kf6/infopage \
"
