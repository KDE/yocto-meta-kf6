# SPDX-FileCopyrightText: 2024 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "ZXing-C++"
DESCRIPTION = "ZXing-C++ is an open-source, multi-format linear/matrix barcode image processing library"
HOMEPAGE = "https://github.com/zxing-cpp/zxing-cpp"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"

# for compatbility with Yocto releases before whinlatter
BB_GIT_DEFAULT_DESTSUFFIX ?= "${BP}"

SRC_URI = "git://github.com/zxing-cpp/zxing-cpp.git;nobranch=1;protocol=https;destsuffix=${BB_GIT_DEFAULT_DESTSUFFIX}"

EXTRA_OECMAKE += "-DBUILD_EXAMPLES=OFF \
                  -DBUILD_DEPENDENCIES=LOCAL \
                  -DBUILD_UNIT_TESTS=OFF \
                  -DBUILD_BLACKBOX_TESTS=OFF \
"

SRCREV = "d6068bcebeb8fd9f0d35a99b00d202be86a14dbe"

inherit cmake
