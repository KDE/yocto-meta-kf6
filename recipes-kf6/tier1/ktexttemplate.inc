# SPDX-FileCopyrightText: 2024 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.1-or-later"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtdeclarative \
"

require ktexttemplate_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums

INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = " \
    ${libdir}/libKF6TextTemplate.so \
"
FILES:${PN} += " \
    ${libdir}/plugins/kf6/ktexttemplate/*.so \
"
