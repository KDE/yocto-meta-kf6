# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018-2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KNewStuff"
DESCRIPTION = "Framework for downloading and sharing additional application data"
HOMEPAGE = "https://invent.kde.org/frameworks/knewstuff"
REUSE_LICENSECHECK_WHITELIST = "CC0-1.0"
LICENSE = "LGPL-2.1-only"

DEPENDS += "attica \
            karchive \
            kauth-native \
            kcompletion \
            kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kiconthemes \
            kio \
            kirigami \
            kitemviews \
            kpackage \
            kpackage-native \
            kservice \
            ktextwidgets \
            kwidgetsaddons \
            kxmlgui \
            libxml2-native \
            qtbase \
            qtdeclarative \
            syndication \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/qml/org/kde/newstuff/* \
                ${libdir}/qml/org/kde/newstuff/qml/* \
                ${datadir}/kf6/knewstuff/pics/*.png \
                ${datadir}/kf6/kmoretools/presets-kmoretools/* \
"
