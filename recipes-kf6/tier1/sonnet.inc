# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020-2024 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "BSD-3-Clause & LGPL-2.0-or-later & LGPL-2.1-or-later"
PR = "r0"

DEPENDS += " \
    qtbase \
    qtdeclarative \
    sonnet-native \
"

DEPENDS:append:class-target = " \
    aspell \
"

RDEPENDS:${PN}:append:class-target = " \
    aspell \
"

SRC_URI:append = " \
    file://0001-Provide-SONNET_NO_BACKENDS-option-to-deactivate-buil.patch \
    file://0002-Remove-ASPELL-runtime-dependency-from-plugin-buildin.patch \
"

require sonnet_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums

EXTRA_OECMAKE:append:class-native = " -DSONNET_USE_WIDGETS=OFF -DSONNET_USE_QML=OFF -DSONNET_NO_BACKENDS=ON"
EXTRA_OECMAKE:append:class-target = " -DPARSETRIGRAMS_EXECUTABLE=${STAGING_DIR_NATIVE}/${bindir}/parsetrigrams6"

FILES:${PN} += " \
    ${libdir}/qml/org/kde/sonnet/ \
    ${libdir}/plugins/kf6/sonnet/ \
"
