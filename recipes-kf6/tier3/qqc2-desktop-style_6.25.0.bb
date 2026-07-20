# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "QQC2 Desktop Style"
DESCRIPTION = "This is a style for Qt Quick Controls which uses the application's QStyle to paint the controls in order to give them native look and feel"
HOMEPAGE = "https://invent.kde.org/frameworks/qqc2-desktop-style"
LICENSE = "LGPL-3.0-only"

DEPENDS += "kauth-native \
            kconfig-native \
            kconfigwidgets \
            kcoreaddons-native \
            kiconthemes \
            kirigami \
            qtbase \
            qtdeclarative \
            sonnet \
"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/plugins/kf6/kirigami/*.so \
                ${libdir}/plugins/kf6/kirigami/platform/*.so \
                ${libdir}/qml/org/kde/desktop/* \
                ${libdir}/qml/org/kde/qqc2desktopstyle/private/* \
                ${libdir}/qml/QtQuick/Controls.2/org.kde.desktop/* \
                ${libdir}/qml/QtQuick/Controls.2/org.kde.desktop/private/* \
"
