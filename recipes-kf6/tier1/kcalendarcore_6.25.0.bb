# SPDX-FileCopyrightText: 2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KCalendarCore"
DESCRIPTION = "Library for Interfacing with Calendars"
HOMEPAGE = "https://invent.kde.org/frameworks/kcalendarcore"

LICENSE = "BSD-3-Clause & LGPL-2.0-or-later"

# licenses only contained in autotests
REUSE_LICENSECHECK_WHITELIST = "LGPL-3.0-or-later"

DEPENDS += "libical qtbase"

inherit kf6_src
inherit kf6_cmake_framework
inherit reuse_license_checksums
