# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

# the licenses are only options for some files
REUSE_LICENSECHECK_WHITELIST = "LicenseRef-KDE-Accepted-GPL LGPL-3.0"
LICENSE = "LGPL-2.0-only"
PR = "r0"

DEPENDS = " \
    qtbase \
    kcoreaddons \
    kcoreaddons-native \
    knotifications \
    kwidgetsaddons \
"

require kjobwidgets_metainfo.inc
inherit kf6-cmake-framework
inherit reuse_license_checksums
