# SPDX-FileCopyrightText: 2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-or-later & BSD-2-Clause"
PR = "r0"

DEPENDS += "qtbase"

require kholidays_metainfo.inc
inherit kf6-cmake
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/qml/org/kde/kholidays \
"
