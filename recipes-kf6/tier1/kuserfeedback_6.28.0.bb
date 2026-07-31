# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KUserFeedback"
DESCRIPTION = "Framework for collecting user feedback for apps via telemetry and surveys"
HOMEPAGE = "https://invent.kde.org/frameworks/kuserfeedback"
LICENSE = "MIT & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=61be4d272e55cc2609d58596cf084908"

DEPENDS += "bison-native flex-native qtbase"

do_compile:append() {
    # Flex and Bison embed their absolute input and output paths in #line
    # directives. Rewrite them before the generated sources are packaged.
    sed -i \
        -e 's|${S}|${TARGET_DBGSRC_DIR}|g' \
        -e 's|${B}|${TARGET_DBGSRC_DIR}|g' \
        ${B}/src/common/surveytargetexpressionscanner.h \
        ${B}/src/common/surveytargetexpressionlexer.cpp \
        ${B}/src/common/surveytargetexpressionparser_p.cpp \
        ${B}/src/common/surveytargetexpressionparser_p.h
}

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums
