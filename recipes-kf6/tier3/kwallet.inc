# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.1-or-later"
PR = "r0"

DEPENDS = " \
    qtbase \
    kcrash \
    kconfig \
    kconfig-native \
    kconfigwidgets \
    kauth-native \
    kcoreaddons \
    kcoreaddons-native \
    kdbusaddons \
    knotifications \
    kservice \
    kwidgetsaddons \
    kwindowsystem \
    libgcrypt \
    qca \
"

EXTRA_OECMAKE += " \
    -DOE_QCA_PATH_HOST_ROOT=${STAGING_DIR_HOST} \
"

inherit pkgconfig
require kwallet_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-ki18n
inherit reuse_license_checksums

FILES:${PN} += " \
    ${datadir}/xdg-desktop-portal/portals/* \
"
