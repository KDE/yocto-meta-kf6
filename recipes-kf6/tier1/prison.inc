# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

REUSE_LICENSECHECK_WHITELIST = "CC0-1.0"
LICENSE = "MIT & BSD-3-Clause"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtdeclarative \
    qtmultimedia \
    qrencode \
    libdmtx \
"

require prison_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/qml/org/kde/prison/ \
"
