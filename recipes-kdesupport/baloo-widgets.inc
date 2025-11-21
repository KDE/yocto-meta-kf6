# SPDX-FileCopyrightText: 2025 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

LICENSE = "GPL-2.0-only | GPL-3.0-only | LGPL-2.0-only | LGPL-2.0-or-later | LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL | LicenseRef-KDE-Accepted-LGPL"

DEPENDS = " \
    kio \
    kfilemetadata \
    baloo \
    kservice \
"

inherit kf6-cmake-framework
inherit kf6-ki18n
inherit kf6-kconfig
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/plugins/kf6/kfileitemaction \
    ${libdir}/plugins/kf6/propertiesdialog \
"
