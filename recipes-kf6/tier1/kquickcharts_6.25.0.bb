# SPDX-FileCopyrightText: 2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KQuickCharts"
DESCRIPTION = "A QtQuick plugin providing high-performance charts"
HOMEPAGE = "https://invent.kde.org/frameworks/kquickcharts"
LICENSE = "MIT & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

DEPENDS += "qtdeclarative"

inherit kf6_src
inherit kf6_cmake_framework
inherit reuse_license_checksums
