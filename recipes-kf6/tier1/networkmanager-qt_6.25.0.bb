# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "NetworkManagerQt"
DESCRIPTION = "Qt wrapper for NetworkManager API"
HOMEPAGE = "https://invent.kde.org/frameworks/networkmanager-qt"
LICENSE = "BSD-3-Clause & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

DEPENDS += "networkmanager qtbase qtdeclarative"

inherit kf6_src
inherit kf6_cmake_framework
inherit reuse_license_checksums

RDEPENDS:${PN} += "networkmanager"
