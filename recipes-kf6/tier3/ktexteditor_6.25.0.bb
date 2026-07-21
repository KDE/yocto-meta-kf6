# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018-2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020-2022 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KTextEditor"
DESCRIPTION = "Full text editor component"
HOMEPAGE = "https://invent.kde.org/frameworks/ktexteditor"
LICENSE = "MIT & BSD-2-Clause & LGPL-2.0-only"

DEPENDS += "karchive \
            kauth-native \
            kconfig \
            kconfig-native \
            kcoreaddons-native \
            kguiaddons \
            kiconthemes \
            kio \
            kparts \
            libxml2-native \
            qtbase \
            sonnet \
            syntax-highlighting \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

# crosscompile support for kcoreaddons_desktop_to_json
EXTRA_OECMAKE += "-DKSERVICETYPE_PATH_kpart.desktop=${STAGING_DATADIR} \
                  -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
"

FILES:${PN} += "${libdir}/plugins/kf6/parts/katepart.so \
                ${datadir}/katepart5/script/README.md \
"
