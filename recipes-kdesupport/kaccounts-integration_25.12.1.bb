# SPDX-FileCopyrightText: 2025 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KAccounts Integration"
DESCRIPTION = "Integration library and QML module for Accounts-SSO and SignOn-SSO"
HOMEPAGE = "https://invent.kde.org/network/kaccounts-integration"
LICENSE = "GPL-2.0-only & GPL-2.0-or-later & GPL-3.0-only & LGPL-2.0-or-later"

require recipes-kdesupport/application_src.inc
inherit kf6_cmake_framework kf6_kconfig kf6_kcmutils
inherit reuse_license_checksums

DEPENDS += "kcoreaddons \
            kdbusaddons \
            ki18n \
            kio \
            kwallet \
            libaccounts-qt \
            qcoro \
            signond \
"

FILES:${PN} += "${libdir}/plugins/kf6 \
                ${libdir}/plugins/kaccounts \
                ${libdir}/plugins/plasma \
"
