# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Plasma Wayland Protocols"
DESCRIPTION = "This project provides the xml files of the non-standard wayland protocols we use in Plasma"
HOMEPAGE = "https://invent.kde.org/libraries/plasma-wayland-protocols"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS += "extra-cmake-modules qtwayland-native"

SRC_URI = "https://download.kde.org/stable/plasma-wayland-protocols/plasma-wayland-protocols-${PV}.tar.xz"
SRC_URI[sha256sum] = "698a7b28b711270314e396e248ae86087cfeaed01372009063995be6e1dc85ba"

inherit qt6-cmake

FILES:${PN}-dev += "${libdir}/cmake/* \
                    ${datadir}/plasma-wayland-protocols/* \
"

BBCLASSEXTEND = "native nativesdk"
