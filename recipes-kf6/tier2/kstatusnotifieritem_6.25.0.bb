# SPDX-FileCopyrightText: 2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KStatusNotifierItem"
DESCRIPTION = "Implementation of Status Notifier Items"
HOMEPAGE = "https://invent.kde.org/frameworks/kstatusnotifieritem"
LICENSE = "CC0-1.0 & LGPL-2.0-or-later"

DEPENDS += "kwindowsystem qtbase"

inherit kf6_src
inherit kf6_cmake_framework
inherit reuse_license_checksums

EXTRA_OECMAKE += "-DBUILD_PYTHON_BINDINGS=OFF"
