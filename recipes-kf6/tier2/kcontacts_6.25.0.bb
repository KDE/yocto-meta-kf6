# SPDX-FileCopyrightText: 2019-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KContacts"
DESCRIPTION = "Library for working with contact information"
HOMEPAGE = "https://invent.kde.org/frameworks/kcontacts"
LICENSE = "MIT & BSD-3-Clause & LGPL-2.0-or-later & Unicode-DFS-2016"

DEPENDS += "kcodecs \
            kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            qtbase \
"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums
