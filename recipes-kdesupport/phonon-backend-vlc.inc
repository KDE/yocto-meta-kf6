# SPDX-FileCopyrightText: 2024 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Phonon VLC backend"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=46d98c0b7542668d6015b992889b2020"
PR = "r0"

DEPENDS += " \
    extra-cmake-modules \
    phonon \
    qtbase \
    qttools-native \
    vlc \
"

RDEPENDS:${PN} += "vlc"

SRC_URI = "https://download.kde.org/stable/phonon/${BPN}/${PV}/${BPN}-${PV}.tar.xz"

inherit qt6-cmake
EXTRA_OECMAKE += " \
    -DPHONON_BUILD_QT5=OFF \
    -DPHONON_BUILD_QT6=ON \
"

FILES:${PN} += " \
    ${libdir}/plugins/phonon4qt6_backend \
"
