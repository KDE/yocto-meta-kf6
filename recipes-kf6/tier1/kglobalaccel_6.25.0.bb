# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020-2024 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KGlobalAccel"
DESCRIPTION = "Global desktop keyboard shortcuts"
HOMEPAGE = "https://invent.kde.org/frameworks/kglobalaccel"
LICENSE = "LGPL-2.0-or-later"

DEPENDS += "qtbase"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums
