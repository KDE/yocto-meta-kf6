# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020-2024 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "BSD-3-Clause & LGPL-2.1-or-later & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"
PR = "r0"

DEPENDS = "qtbase bison-native"

require solid_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/qml/org/kde/solid/qmldir \
    ${libdir}/qml/org/kde/solid/*.so \
"

RRECOMMENDS:${PN}:append = " \
    udisks2 \
    upower \
"
