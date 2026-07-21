# SPDX-FileCopyrightText: 2018-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Integration for Frameworks"
DESCRIPTION = "Integration of Qt application with KDE workspaces"
HOMEPAGE = "https://invent.kde.org/frameworks/frameworkintegration"
LICENSE = "LGPL-2.0-only"

DEPENDS += "kauth-native \
            kconfig \
            kconfig-native \
            kconfigwidgets \
            kcoreaddons-native \
            kiconthemes \
            knewstuff \
            knotifications \
            kpackage \
            kpackage-native \
            kwidgetsaddons \
            qtbase \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit kf6_kdoctools
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/plugins/kf6/FrameworkIntegrationPlugin.so \
                ${datadir}/kf6/infopage \
"
