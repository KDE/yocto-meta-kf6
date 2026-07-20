# SPDX-FileCopyrightText: 2018-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Syndication"
DESCRIPTION = "An RSS/Atom parser library"
HOMEPAGE = "https://invent.kde.org/frameworks/syndication"
LICENSE = "LGPL-2.0-or-later"

DEPENDS += "kcodecs qtbase"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums
