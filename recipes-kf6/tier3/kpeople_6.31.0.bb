# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KPeople"
DESCRIPTION = "Provides access to all contacts and aggregates them by person"
HOMEPAGE = "https://invent.kde.org/frameworks/kpeople"
LICENSE = "LGPL-2.1-or-later"

DEPENDS += "kconfig-native \
            kcontacts \
            kcoreaddons \
            kcoreaddons-native \
            kitemviews \
            kwidgetsaddons \
            qtbase \
            qtdeclarative \
"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/qml/org/kde/people/* \
                ${libdir}/plugins/kpeople/datasource/KPeopleVCard.so \
"
