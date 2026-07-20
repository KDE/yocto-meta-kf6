# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KColorScheme"
DESCRIPTION = "Classes to read and interact with KColorScheme"
HOMEPAGE = "https://invent.kde.org/frameworks/kcolorscheme"
LICENSE = "BSD-2-Clause & LGPL-2.0-or-later & LGPL-2.1-only & LGPL-3.0-only"

DEPENDS += "kguiaddons qtbase"

inherit kf6
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit kf6_kconfig
inherit reuse_license_checksums
