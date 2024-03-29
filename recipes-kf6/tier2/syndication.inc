# SPDX-FileCopyrightText: 2018-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-or-later"
PR = "r0"

DEPENDS = " \
    qtbase \
    kcodecs \
"

require syndication_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums
