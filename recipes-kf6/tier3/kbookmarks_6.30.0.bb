# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KBookmarks"
DESCRIPTION = "Bookmarks management library"
HOMEPAGE = "https://invent.kde.org/frameworks/kbookmarks"
LICENSE = "LGPL-2.0-only"

DEPENDS += "kauth-native \
            kcodecs \
            kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kiconthemes \
            kwidgetsaddons \
            kxmlgui \
            qtbase \
"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums
