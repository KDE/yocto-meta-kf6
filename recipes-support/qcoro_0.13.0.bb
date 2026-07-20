# SPDX-FileCopyrightText: 2021-2022 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "QCoro"
DESCRIPTION = "Coroutines for Qt"
HOMEPAGE = "https://github.com/danvratil/qcoro"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=387248cdf922178ee3fdc379e28542dc"

DEPENDS += "qtbase \
            qtdeclarative \
            qttools \
            qttools-native \
"

# for compatbility with Yocto releases before whinlatter
BB_GIT_DEFAULT_DESTSUFFIX ?= "${BP}"

SRC_URI = "git://github.com/danvratil/qcoro.git;nobranch=1;protocol=https;destsuffix=${BB_GIT_DEFAULT_DESTSUFFIX}"

SRCREV = "720ea7f6322bbba9f5d5aa3888a222397a1f72f1"

inherit qt6-cmake

EXTRA_OECMAKE += "-DQCORO_WITH_QTWEBSOCKETS=OFF"
EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"
EXTRA_OECMAKE += "-DQML_INSTALL_DIR=${@os.path.relpath(d.getVar('QT6_INSTALL_QMLDIR'), d.getVar('prefix') + '/')}"

FILES:${PN}-dev += "${prefix}/mkspecs"
FILES:${PN} += "${libdir}/qml"
