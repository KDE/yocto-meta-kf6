# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018-2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KCMUtils"
DESCRIPTION = "Utilities for KDE System Settings modules"
HOMEPAGE = "https://invent.kde.org/frameworks/kcmutils"
LICENSE = "LGPL-2.0-only"

DEPENDS:append:class-target = " \
    kconfig-native \
    kconfigwidgets \
    kcoreaddons \
    kcoreaddons-native \
    kiconthemes \
    kio \
    kirigami \
    kitemviews \
    kpackage \
    kpackage-native \
    kxmlgui \
    libxml2-native \
    qtbase \
"

DEPENDS:append:class-native = " \
    extra-cmake-modules-native \
    qtbase-native \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

EXTRA_OECMAKE:class-native = "-DTOOLS_ONLY=ON "

FILES:${PN} += "${libdir}/qml/org/kde/kcmutils/"
