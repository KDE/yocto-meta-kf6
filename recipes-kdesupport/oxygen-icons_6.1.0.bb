# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Oxygen Icons"
DESCRIPTION = "Oxygen-icons is a freedesktop.org compatible icon theme"
HOMEPAGE = "https://invent.kde.org/frameworks/oxygen-icons"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "https://download.kde.org/stable/oxygen-icons/oxygen-icons-6.1.0.tar.xz"
SRC_URI[sha256sum] = "16ca971079c5067c4507cabf1b619dc87dd6b326fd5c2dd9f5d43810f2174d68"

inherit kf6_cmake_framework

FILES:${PN} += "${datadir}/icons/oxygen/index.theme \
                ${datadir}/icons/oxygen/base/*/*/*.png \
                ${datadir}/icons/oxygen/applets/*/*.svg \
"
