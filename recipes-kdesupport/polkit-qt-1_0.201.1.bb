# SPDX-FileCopyrightText: 2017, 2020 Volker Krause <vkrause@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Polkit-Qt-1"
DESCRIPTION = "Polkit-qt is a library that lets developers use the PolicyKit API through a nice Qt-styled API"
HOMEPAGE = "https://invent.kde.org/libraries/polkit-qt-1"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.0-or-later.txt;md5=da48810c4ddf8e49efa031294a26b98c"

DEPENDS += "polkit qtbase"

# for compatbility with Yocto releases before whinlatter
BB_GIT_DEFAULT_DESTSUFFIX ?= "${BP}"

SRC_URI = "git://invent.kde.org/libraries/polkit-qt-1.git;nobranch=1;protocol=https;destsuffix=${BB_GIT_DEFAULT_DESTSUFFIX}"

SRCREV = "328a4c8615c7207e1297b776026657a77c6a71b6"

inherit kf6_cmake_framework

FILES:${PN}-dev += "${libdir}/cmake/*"
