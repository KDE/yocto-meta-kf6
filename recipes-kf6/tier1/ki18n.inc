# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020-2021 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-or-later & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL) & BSD-3-Clause"
PR = "r0"

SRC_URI:append = " file://0001-Allow-explicit-setting-of-Python3-fallback-executibl.patch"

DEPENDS:class-native = " \
    qtbase \
    gettext-native \
    extra-cmake-modules-native \
"
DEPENDS:class-target = " \
    qtdeclarative \
    gettext-native \
    extra-cmake-modules \
"

require ki18n_metainfo.inc
inherit kf6-cmake-framework
inherit python3native
inherit reuse_license_checksums

EXTRA_OECMAKE:class-native = " -DBUILD_WITH_QTSCRIPT=OFF -DLibIntl_SEARCH_PATH=/usr/include"
EXTRA_OECMAKE:append = " -DFALLBACK_KI18N_PYTHON_EXECUTABLE=${bindir}/python3-native/python3"

RDEPENDS:${PN}:class-target = " iso-codes"

FILES:${PN} += " \
    ${libdir}/plugins/kf6/ktranscript.so \
    ${libdir}/qml/org/kde/i18n/localeData \
"
