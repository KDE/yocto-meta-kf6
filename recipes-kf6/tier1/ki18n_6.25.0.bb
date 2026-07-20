# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020-2021 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Ki18n"
DESCRIPTION = "KI18n provides functionality for internationalizing user interface text in applications"
HOMEPAGE = "https://invent.kde.org/frameworks/ki18n"
LICENSE = "LGPL-2.0-or-later & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL) & BSD-3-Clause"

DEPENDS:append:class-native = " \
    extra-cmake-modules-native \
    gettext-native \
    qtbase \
"
DEPENDS:append:class-target = " \
    extra-cmake-modules \
    gettext-native \
    qtdeclarative \
"

inherit kf6
inherit kf6_cmake_framework
inherit python3native
inherit reuse_license_checksums

EXTRA_OECMAKE:class-native = "-DBUILD_WITH_QTSCRIPT=OFF -DLibIntl_SEARCH_PATH=${includedir}"
EXTRA_OECMAKE:append = " -DFALLBACK_KI18N_PYTHON_EXECUTABLE=${bindir}/python3-native/python3"

FILES:${PN} += "${libdir}/plugins/kf6/ktranscript.so \
                ${libdir}/qml/org/kde/i18n/localeData \
"

RDEPENDS:${PN}:class-target = "iso-codes"
