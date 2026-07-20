# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Breeze Icons"
DESCRIPTION = "Breeze icon theme"
HOMEPAGE = "https://invent.kde.org/frameworks/breeze-icons"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

inherit kf6
inherit kf6_cmake_framework
# bash is in the hosttools folder in PATH, but that's not detected automatically
# due to the CMAKE_FIND_ROOT_PATH settings
EXTRA_OECMAKE:class-target += "-DBASH_EXE=`which bash`"

DEPENDS += "breeze-icons-native \
            python3-lxml-native \
"

SRC_URI:append:class-target = " file://use_generate_symbolic_dark_sysroot.patch"

do_install:append:class-native() {
    install -d ${D}/${bindir}
    install ${B}/bin/qrcAlias ${D}/${bindir}
    install ${B}/bin/generate-symbolic-dark ${D}/${bindir}
}

FILES:${PN} += "${datadir}/icons/breeze \
                ${datadir}/icons/breeze-dark \
"
