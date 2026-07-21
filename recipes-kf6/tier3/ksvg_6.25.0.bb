# SPDX-FileCopyrightText: 2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KSVG"
DESCRIPTION = "A library for rendering SVG-based themes with stylesheet re-coloring and on-disk caching"
HOMEPAGE = "https://invent.kde.org/frameworks/ksvg"
LICENSE = "BSD-2-Clause & LGPL-2.0-or-later"

DEPENDS += "karchive \
            kcolorscheme \
            kcoreaddons \
            kguiaddons \
            kirigami \
            qtbase \
            qtdeclarative \
"

inherit kf6_kconfig
inherit kf6_src
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/qml/org/kde/ksvg/*"
