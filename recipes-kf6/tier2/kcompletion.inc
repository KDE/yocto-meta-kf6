# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "BSD-3-Clause & LGPL-2.0-or-later & LGPL-2.1-or-later"
PR = "r0"

DEPENDS = " \
    qtbase \
    kwidgetsaddons \
    kcodecs \
    kconfig \
    kconfig-native \
"

require kcompletion_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums
