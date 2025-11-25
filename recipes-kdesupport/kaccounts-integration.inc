# SPDX-FileCopyrightText: 2025 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KAccounts Integration"
DESCRIPTION = "Integration library and QML module for Accounts-SSO and SignOn-SSO"
HOMEPAGE = "https://invent.kde.org/network/kaccounts-integration"
LICENSE = "GPL-2.0-only & GPL-2.0-or-later & GPL-3.0-only & LGPL-2.0-or-later"

inherit kf6-cmake-framework kf6-kconfig kf6-kcmutils
inherit reuse_license_checksums

DEPENDS += " \
    kcmutils \
    kcoreaddons \
    kdbusaddons \
    ki18n \
    kio \
    kwallet \
    libaccounts-qt \
    signond \
    qcoro \
"

FILES:${PN} += " \
    ${libdir}/plugins/kf6 \
    ${libdir}/plugins/kaccounts \
    ${libdir}/plugins/plasma \
"
