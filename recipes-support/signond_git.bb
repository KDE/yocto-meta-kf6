# SPDX-FileCopyrightText: 2025 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

SUMMARY = "SignOn daemon"
DESCRIPTION = "The SignOn daemon is a D-Bus service which performs user authentication on \
behalf of its clients."
HOMEPAGE = "https://gitlab.com/accounts-sso/signond"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

inherit qt6-qmake pkgconfig

# Use fork for Qt6 compatibility
SRC_URI = " \
    git://gitlab.com/nicolasfella/signond.git;branch=qt6;protocol=https \
    file://0001-Disable-doc-generation.patch \
"
SRCREV = "c8ad98249af541514ff7a81634d3295e712f1a39"

S = "${WORKDIR}/git"

DEPENDS += " \
    qtbase \
"

FILES:${PN} += " \
    ${libdir}/signon \
    ${datadir}/dbus-1 \
"

do_install:append() {
    # Fix hard-coded cmake file
    sed -i "s;/usr/include;\$ENV{STAGING_INCDIR};g" ${D}${libdir}/cmake/SignOnQt6/SignOnQt6Config.cmake
}
