# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KWallet Framework"
DESCRIPTION = "Safe desktop-wide storage for passwords"
HOMEPAGE = "https://invent.kde.org/frameworks/kwallet"
LICENSE = "LGPL-2.1-or-later"

DEPENDS += "kauth-native \
            kconfig \
            kconfig-native \
            kconfigwidgets \
            kcoreaddons \
            kcoreaddons-native \
            kcrash \
            kdbusaddons \
            knotifications \
            kservice \
            kwidgetsaddons \
            kwindowsystem \
            libgcrypt \
            libsecret \
            qca \
            qtbase \
"

EXTRA_OECMAKE += "-DOE_QCA_PATH_HOST_ROOT=${STAGING_DIR_HOST}"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

FILES:${PN} += "${datadir}/xdg-desktop-portal/portals/*"
