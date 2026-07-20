# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020-2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT
#
# requires session management support in QtGui
# eg. via PACKAGECONFIG:append:pn-qtbase = "sm" in local.conf

SUMMARY = "KConfig"
DESCRIPTION = "Persistent platform-independent application settings"
HOMEPAGE = "https://invent.kde.org/frameworks/kconfig/"

LICENSE = "MIT & BSD-2-Clause & BSD-3-Clause & LGPL-2.0-or-later & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

DEPENDS += "kconfig-native qtbase"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums

EXTRA_OECMAKE:class-native += "-DKCONFIG_USE_GUI=OFF"

FILES:${PN} += "${libdir}/qml/org/kde/config/qmldir \
                ${libdir}/qml/org/kde/config/*.so \
                ${libexecdir}/kf6/kconf_update \
"

FILES:${PN}-dev += "${libexecdir}/kf6/kconfig_compiler_kf6"
