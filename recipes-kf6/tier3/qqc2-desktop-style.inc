# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-3.0-only"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtdeclarative \
    kirigami \
    kiconthemes \
    kconfigwidgets \
    kcoreaddons-native \
    kconfig-native \
    kauth-native \
"

require qqc2-desktop-style_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/plugins/kf6/kirigami/*.so \
    ${libdir}/plugins/kf6/kirigami/platform/*.so \
    ${libdir}/qml/org/kde/desktop/* \
    ${libdir}/qml/org/kde/qqc2desktopstyle/private/* \
    ${libdir}/qml/QtQuick/Controls.2/org.kde.desktop/* \
    ${libdir}/qml/QtQuick/Controls.2/org.kde.desktop/private/* \
"
