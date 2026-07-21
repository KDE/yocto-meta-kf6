# SPDX-FileCopyrightText: 2024 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KTextTemplate"
DESCRIPTION = "Library to allow application developers to separate the structure of documents from the data they contain"
HOMEPAGE = "https://invent.kde.org/frameworks/ktexttemplate"
LICENSE = "LGPL-2.1-or-later"

DEPENDS += "qtbase qtdeclarative"

inherit kf6_src
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/plugins/kf6/ktexttemplate/*.so"
