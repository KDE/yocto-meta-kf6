# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "BSD-2-Clause & LGPL-2.0-or-later & LGPL-2.1-only & LGPL-3.0-only"
PR = "r0"

DEPENDS = " \
    qtbase \
    kguiaddons \
"

require kcolorscheme_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-ki18n
inherit kf6-kconfig
inherit reuse_license_checksums
