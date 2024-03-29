# SPDX-FileCopyrightText: 2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "BSD-3-Clause & LGPL-2.0-or-later"
PR = "r0"

# licenses only contained in autotests
REUSE_LICENSECHECK_WHITELIST = "LGPL-3.0-or-later"

DEPENDS = " \
    qtbase \
    libical \
"

require kcalendarcore_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums
