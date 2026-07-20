# SPDX-FileCopyrightText: 2019-2020 Volker Krause <vkrause@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "QCA"
DESCRIPTION = "Qt Cryptographic Architecture"
HOMEPAGE = "https://invent.kde.org/libraries/qca/"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

DEPENDS += "qt5compat qtbase"

SRC_URI = "https://download.kde.org/stable/qca/${PV}/qca-${PV}.tar.xz"
SRC_URI[sha256sum] = "1c5b722da93d559365719226bb121c726ec3c0dc4c67dea34f1e50e4e0d14a02"

PACKAGECONFIG = "botan cyrus-sasl libgcrypt nss"
PACKAGECONFIG[botan] = ",,botan"
PACKAGECONFIG[cyrus-sasl] = ",,cyrus-sasl"
PACKAGECONFIG[libgcrypt] = ",,libgcrypt"
PACKAGECONFIG[nss] = ",,nss"

inherit kf6_cmake_framework

EXTRA_OECMAKE += "-DQT_MAJOR_VERSION=6 \
                  -DBUILD_WITH_QT6=ON \
                  -DQCA_FEATURE_INSTALL_DIR=${libdir}${QT_DIR_NAME}/mkspecs/features \
                  -DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')} \
"

FILES:${PN} += "${libdir}/qca-qt6/crypto/libqca-*.so"

FILES:${PN}-dev += "${libdir}/mkspecs/features/*  \
                    ${libdir}/cmake/qca-qt6/*.cmake \
"
