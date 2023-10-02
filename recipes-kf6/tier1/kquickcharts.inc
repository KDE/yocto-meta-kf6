# SPDX-FileCopyrightText: 2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "MIT & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"
PR = "r0"

DEPENDS = " \
    qtdeclarative \
"

require kquickcharts_metainfo.inc
inherit kf6-cmake
inherit reuse_license_checksums

FILES:${PN} += " \
  ${libdir}/qml/org/kde/quickcharts \
"
