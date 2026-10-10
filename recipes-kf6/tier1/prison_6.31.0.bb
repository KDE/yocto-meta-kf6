# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Prison"
DESCRIPTION = "Prison is a barcode api currently offering a nice Qt api to produce QRCode barcodes and DataMatrix barcodes"
HOMEPAGE = "https://invent.kde.org/frameworks/prison"
REUSE_LICENSECHECK_WHITELIST = "CC0-1.0"
LICENSE = "MIT & BSD-3-Clause"

DEPENDS += "libdmtx \
            qrencode \
            qtbase \
            qtdeclarative \
            qtmultimedia \
            zxing-cpp \
"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/qml/org/kde/prison/"
