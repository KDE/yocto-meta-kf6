# SPDX-FileCopyrightText: 2024 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "ZXing-C++"
HOMEPAGE = "https://github.com/zxing-cpp/zxing-cpp"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"

SRC_URI = " \
    git://github.com/zxing-cpp/zxing-cpp.git;nobranch=1;protocol=https \
"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " \
    -DBUILD_EXAMPLES=OFF \
    -DBUILD_DEPENDENCIES=LOCAL \
    -DBUILD_UNIT_TESTS=OFF \
    -DBUILD_BLACKBOX_TESTS=OFF \
"

inherit cmake
