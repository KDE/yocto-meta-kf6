# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2019 Hannah Kiekens <hannahkiekens@gmail.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KFileMetaData"
DESCRIPTION = "A library for extracting file metadata"
HOMEPAGE = "https://invent.kde.org/frameworks/kfilemetadata"
LICENSE = "BSD-3-Clause & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

DEPENDS += "ffmpeg \
            karchive \
            kcodecs \
            kcoreaddons \
            kcoreaddons-native \
            libkexiv2 \
            poppler \
            qtbase \
            taglib \
"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit kf6_kconfig
inherit features_check
inherit reuse_license_checksums

REQUIRED_DISTRO_FEATURES += "xattr"

FILES:${PN} += "${libdir}/plugins/kf6/kfilemetadata/*.so \
                ${libdir}/plugins/kf6/kfilemetadata/writers/*.so \
"
