# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "MIT & BSD-3-Clause"
LIC_FILES_CHKSUM = " \
    file://COPYING.LIB;md5=61be4d272e55cc2609d58596cf084908 \
"

DEPENDS = " \
    qtbase \
"

require kquickcharts_metainfo.inc
inherit kf6-cmake
inherit reuse_license_checksums
inherit mime-xdg
