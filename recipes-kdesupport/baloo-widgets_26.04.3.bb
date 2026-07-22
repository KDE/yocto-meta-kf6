# SPDX-FileCopyrightText: 2025 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Baloo Widgets"
DESCRIPTION = "Widgets for Baloo"
HOMEPAGE = "https://invent.kde.org/libraries/baloo-widgets"
LICENSE = "GPL-2.0-only | GPL-3.0-only | LGPL-2.0-only | LGPL-2.0-or-later | LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL | LicenseRef-KDE-Accepted-LGPL"

DEPENDS += "baloo \
            kfilemetadata \
            kio \
            kservice \
"

require recipes-kdesupport/application_src.inc
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit kf6_kconfig
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/plugins/kf6/kfileitemaction \
                ${libdir}/plugins/kf6/propertiesdialog \
"
