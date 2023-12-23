# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.1-only"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtdeclarative \
    kcoreaddons \
    kcoreaddons-native \
    ki18n \
    kconfig \
    kconfig-native \
    kio \
    kauth-native \
    kirigami \
    knotifications \
"

require purpose_metainfo.inc
inherit kf6-cmake-framework
inherit gettext
inherit python3native
inherit kf6-kdoctools
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/plugins/kf6/kfileitemaction/* \
    ${libdir}/plugins/kf6/purpose/* \
    ${libdir}/qml/org/kde/purpose/* \
    ${datadir}/icons/hicolor/* \
    ${datadir}/kf6/purpose/* \
"
