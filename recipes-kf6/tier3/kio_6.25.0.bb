# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KIO"
DESCRIPTION = "Network transparent access to files and data"
HOMEPAGE = "https://invent.kde.org/frameworks/kio"
REUSE_LICENSECHECK_WHITELIST = "Qt-Commercial-exception-1.0 CC0-1.0"
LICENSE = "LGPL-2.0-only & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL) & BSD-2-Clause & BSD-3-Clause & MIT & (GPL-2.0-only | GPL-3.0-only | LicenseRef-KDE-Accepted-GPL)"

DEPENDS += "karchive \
            kbookmarks \
            kcompletion \
            kcrash \
            kdbusaddons \
            kiconthemes \
            kitemviews \
            kjobwidgets \
            kservice \
            ktextwidgets \
            kwallet \
            kwidgetsaddons \
            kwindowsystem \
            qtbase \
            solid \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_kcoreaddons
inherit kf6_kconfig
inherit kf6_ki18n
inherit kf6_kdoctools
inherit kf6_kauth
inherit reuse_license_checksums

FILES_SOLIBSDEV = ""
FILES:${PN} += "${datadir}/kconf_update \
                ${datadir}/kf6/kcookiejar/domain_info \
                ${datadir}/kf6/searchproviders/* \
                ${datadir}/kservices6/useragentstrings/*.desktop \
                ${libdir}/libkuriikwsfiltereng_private.so \
                ${libdir}/plugins/kcm_*.so \
                ${libdir}/plugins/kf6/kded/*.so \
                ${libdir}/plugins/kf6/kio/*.so \
                ${libdir}/plugins/kf6/kio_dnd/*.so \
                ${libdir}/plugins/kf6/kiod/*.so \
                ${libdir}/plugins/kf6/urifilters/*.so \
                ${libdir}/plugins/plasma/kcms/systemsettings/*.so \
                ${libdir}/plugins/plasma/kcms/systemsettings_qwidgets/*.so \
"

FILES:${PN}-dev += "${libdir}/libKF6KIOGui.so \
                    ${libdir}/libKF6KIOWidgets.so \
                    ${libdir}/libKF6KIOFileWidgets.so \
                    ${libdir}/libKF6KIOCore.so \
"

RDEPENDS:${PN} += "ca-certificates"
