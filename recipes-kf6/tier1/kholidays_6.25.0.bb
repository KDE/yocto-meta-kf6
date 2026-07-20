# SPDX-FileCopyrightText: 2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KHolidays"
DESCRIPTION = "Library to assist determining when holidays occur"
HOMEPAGE = "https://invent.kde.org/frameworks/kholidays"
LICENSE = "LGPL-2.0-or-later & BSD-2-Clause"

DEPENDS += "bison-native \
            qtbase \
"

SRC_URI:append = " file://0001-Fix-reproducible-build-issues.patch"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums

EXTRA_OECMAKE += "-DBISON_TARGET_ARG_COMPILE_FLAGS='--no-lines --file-prefix-map=${S}=${TARGET_DBGSRC_DIR} --file-prefix-map=${B}=${TARGET_DBGSRC_DIR}'"

FILES:${PN} += "${libdir}/qml/org/kde/kholidays"
