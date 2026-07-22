# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KUserFeedback"
DESCRIPTION = "Framework for collecting user feedback for apps via telemetry and surveys"
HOMEPAGE = "https://invent.kde.org/frameworks/kuserfeedback"
LICENSE = "MIT & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=61be4d272e55cc2609d58596cf084908"

DEPENDS += "qtbase"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums
