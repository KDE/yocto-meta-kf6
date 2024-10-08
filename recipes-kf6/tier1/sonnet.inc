# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "BSD-3-Clause & LGPL-2.0-or-later & LGPL-2.1-or-later"
PR = "r0"

DEPENDS += " \
    qtbase \
    qtdeclarative \
    sonnet-native \
"

require sonnet_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums

EXTRA_OECMAKE:append:class-native = " -DSONNET_USE_WIDGETS=OFF -DSONNET_USE_QML=OFF"
EXTRA_OECMAKE:append:class-target = " -DPARSETRIGRAMS_EXECUTABLE=${STAGING_DIR_NATIVE}/${bindir}/parsetrigrams6"

FILES:${PN} += " \
    ${libdir}/qml/org/kde/sonnet/ \
"
