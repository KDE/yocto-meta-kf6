# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

# the licenses are only options for some files

SUMMARY = "KJobWidgets"
DESCRIPTION = "Widgets for showing progress of asynchronous jobs"
HOMEPAGE = "https://invent.kde.org/frameworks/kjobwidgets"
REUSE_LICENSECHECK_WHITELIST = "LicenseRef-KDE-Accepted-GPL LGPL-3.0"
LICENSE = "LGPL-2.0-only"

DEPENDS += "kcoreaddons \
            kcoreaddons-native \
            knotifications \
            kwidgetsaddons \
            qtbase \
"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums

EXTRA_OECMAKE += "-DBUILD_PYTHON_BINDINGS=OFF"
