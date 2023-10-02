# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-only"
PR = "r0"

DEPENDS = " \
    qtdeclarative \
    qtsvg \
"

require kirigami_metainfo.inc
inherit kf6-cmake
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/qml/org/kde/kirigami/* \
    ${libdir}/qml/org/kde/kirigami.2/* \
"

RDEPENDS:${PN} += " \
    qtdeclarative-qmlplugins \
"
