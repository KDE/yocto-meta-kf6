# SPDX-FileCopyrightText: 2025 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Accounts management library for Qt applications"
DESCRIPTION = "This project is a library for managing accounts which can be used from Qt \
applications. It is part of the accounts-sso project."
HOMEPAGE = "https://gitlab.com/accounts-sso/libaccounts-qt"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

inherit qt6-qmake pkgconfig

SRC_URI = " \
    git://gitlab.com/accounts-sso/libaccounts-qt.git;branch=master;protocol=https \
    file://0001-Disable-doc-generation.patch \
"
SRCREV = "57641e601bbb1cd1dd63d616a83eab341515c3ee"

S = "${WORKDIR}/git"

DEPENDS += " \
    qtbase \
    glib-2.0 \
    libaccounts-glib \
"

#EXTRA_OEMAKE = "INSTALL_PREFIX='${prefix}'"

do_install:append() {
    # do not install test executable
    rm -f ${D}${bindir}/accountstest
    rmdir ${D}${bindir}

    # Fix hard-coded cmake file
    sed -i "s;/usr/include;\$ENV{STAGING_INCDIR};g" ${D}${libdir}/cmake/AccountsQt6/AccountsQt6Config.cmake
}
