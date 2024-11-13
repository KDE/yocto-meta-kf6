# SPDX-FileCopyrightText: 2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "CC0-1.0 & LGPL-2.0-or-later"
PR = "r0"

DEPENDS += " \
    qtbase \
    kwindowsystem \
"

require kstatusnotifieritem_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums
