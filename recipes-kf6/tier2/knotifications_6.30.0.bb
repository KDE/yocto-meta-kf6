# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KNotifications"
DESCRIPTION = "Desktop notifications"
HOMEPAGE = "https://invent.kde.org/frameworks/knotifications"
LICENSE = "LGPL-2.1-only"

DEPENDS += "kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kwindowsystem \
            libcanberra \
            qtbase \
"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/qml/org/kde/notification/*"

EXTRA_OECMAKE += "-DBUILD_PYTHON_BINDINGS=OFF"
