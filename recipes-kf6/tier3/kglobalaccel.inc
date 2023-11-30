# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-or-later"
PR = "r0"

DEPENDS = " \
    qtbase \
    kcoreaddons \
    kcoreaddons-native \
    kconfig \
    kconfig-native \
    kcrash \
    kdbusaddons \
"

require kglobalaccel_metainfo.inc
inherit kf6-cmake
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/plugins/org.kde.kglobalaccel5.platforms/*.so \
    ${libdir}/systemd \
"
