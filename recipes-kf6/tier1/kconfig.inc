# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020-2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT
#
# requires session management support in QtGui
# eg. via PACKAGECONFIG:append:pn-qtbase = "sm" in local.conf

LICENSE = "MIT & BSD-2-Clause & BSD-3-Clause & LGPL-2.0+ & (LGPL-2.1 | LGPL-3.0 | LicenseRef-KDE-Accepted-LGPL)"
PR = "r0"

DEPENDS = "qtbase kconfig-native"

require kconfig_metainfo.inc
inherit cmake_kf6
inherit reuse_license_checksums
EXTRA_OECMAKE:class-native = " -DKCONFIG_USE_GUI=OFF"

FILES:${PN}-dev += " \
    ${libexecdir}/kf6/kconfig_compiler_kf6 \
"
