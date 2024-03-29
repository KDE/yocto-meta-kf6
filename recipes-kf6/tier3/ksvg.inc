# SPDX-FileCopyrightText: 2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "BSD-2-Clause & LGPL-2.0-or-later"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtdeclarative \
    karchive \
    kcoreaddons \
    kcolorscheme \
    kguiaddons \
    kirigami \
"

require ksvg_metainfo.inc
inherit kf6-kconfig
inherit kf6-cmake-framework
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/qml/org/kde/ksvg/* \
"
