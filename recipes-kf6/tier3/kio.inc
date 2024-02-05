# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

REUSE_LICENSECHECK_WHITELIST = "Qt-Commercial-exception-1.0 CC0-1.0"
LICENSE = "LGPL-2.0-only & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL) & BSD-2-Clause & BSD-3-Clause & MIT & (GPL-2.0-only | GPL-3.0-only | LicenseRef-KDE-Accepted-GPL)"
PR = "r0"

DEPENDS = " \
    qtbase \
    karchive \
    kdbusaddons \
    kcrash \
    kservice \
    solid \
    kbookmarks \
    kcompletion \
    kconfigwidgets \
    kiconthemes \
    kitemviews \
    kjobwidgets \
    ktextwidgets \
    kwallet \
    kwidgetsaddons \
    kwindowsystem \
"

require kio_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-kcoreaddons
inherit kf6-kconfig
inherit kf6-ki18n
inherit kf6-kdoctools
inherit kf6-kauth
inherit mime-xdg
inherit reuse_license_checksums

# handling symlink: /usr/lib/plugins/plasma/kcms/systemsettings_qwidgets/kcm_webshortcuts.so
INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${libdir}/plugins/kcm_*.so \
    ${libdir}/plugins/kf6/kio/*.so \
    ${libdir}/plugins/kf6/kded/*.so \
    ${libdir}/plugins/kf6/kiod/*.so \
    ${libdir}/plugins/kf6/urifilters/*.so \
    ${libdir}/libkuriikwsfiltereng_private.so \
    ${libdir}/plugins/plasma/kcms/systemsettings/*.so \
    ${libdir}/plugins/plasma/kcms/systemsettings_qwidgets/*.so \
    ${datadir}/kservices6/useragentstrings/*.desktop \
    ${datadir}/kf6/kcookiejar/domain_info \
    ${datadir}/kf6/searchproviders/* \
    ${datadir}/kconf_update \
"

FILES:${PN}-dev += " \
    ${libdir}/libKF6KIOGui.so \
    ${libdir}/libKF6KIOWidgets.so \
    ${libdir}/libKF6KIOFileWidgets.so \
    ${libdir}/libKF6KIOCore.so \
"

RDEPENDS:${PN} += " \
    ca-certificates \
"
