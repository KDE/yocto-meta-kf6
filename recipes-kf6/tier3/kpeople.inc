# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.1-or-later"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtdeclarative \
    kcontacts \
    kconfig-native \
    kcoreaddons \
    kcoreaddons-native \
    kwidgetsaddons \
    kitemviews \
"

require kpeople_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-ki18n
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/qml/org/kde/people/* \
    ${libdir}/plugins/kpeople/datasource/KPeopleVCard.so \
"
