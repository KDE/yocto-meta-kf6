# SPDX-FileCopyrightText: 2017 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2021 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Library for reading and writing data matrix barcodes"
HOMEPAGE = "https://github.com/dmtx"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b58872aaf3a9d51c1f002b9d7940f4f1"

inherit autotools

SRCREV = "500d7af6106713610a0f8b2d96aefa81912b96bc"
SRC_URI = "git://github.com/dmtx/libdmtx;nobranch=1;protocol=https"
S = "${WORKDIR}/git"
