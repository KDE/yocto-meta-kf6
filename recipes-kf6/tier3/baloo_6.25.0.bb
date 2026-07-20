# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018-2020 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Baloo"
DESCRIPTION = "Baloo is a framework for searching and managing metadata"
HOMEPAGE = "https://invent.kde.org/frameworks/baloo"
LICENSE = "LGPL-2.1-only"

DEPENDS += "kauth-native \
            kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kcrash \
            kdbusaddons \
            kfilemetadata \
            kidletime \
            kio \
            libxml2-native \
            lmdb \
            qtbase \
            qtdeclarative \
            solid \
"

# nooelint: oelint.file.patchsignedoff - TODO: get Signed-off-by entry
SRC_URI:append:riscv64 = " \
    file://0001-we-cant-mmap-such-a-large-memory-on-riscv64.patch \
"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/plugins/kf6/kio/*.so \
                ${libdir}/plugins/kf6/kded/*.so \
                ${libdir}/systemd/user/* \
                ${libdir}/qml/org/kde/baloo/* \
                ${libdir}/qml/org/kde/baloo/experimental/* \
                ${datadir}/icons/hicolor/128x128/apps/baloo.png \
"

RDEPENDS:${PN} += "lmdb"
