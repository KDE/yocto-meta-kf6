# SPDX-FileCopyrightText: 2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "BSD-2-Clause & LGPL-2.0+"
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

inherit kf6-kconfig
inherit kf6-cmake
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/qml/org/kde/ksvg/* \
"
