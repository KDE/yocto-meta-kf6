# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2019 Hannah Kiekens <hannahkiekens@gmail.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "BSD-3-Clause & (LGPL-2.1 | LGPL-3.0 | LicenseRef-KDE-Accepted-LGPL)"
PR = "r0"

DEPENDS += " \
    qtbase \
    qt5compat \
    karchive \
    kcoreaddons \
    kcoreaddons-native \
"

require kfilemetadata_metainfo.inc
inherit cmake_kf6
inherit ki18n
inherit features_check
inherit reuse_license_checksums

REQUIRED_DISTRO_FEATURES += "xattr"

FILES:${PN} += " \
  ${libdir}/plugins/kf6/kfilemetadata/*.so \
"
