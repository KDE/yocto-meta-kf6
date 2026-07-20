# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "BluezQt"
DESCRIPTION = "Qt wrapper for Bluez 5 DBus API"
HOMEPAGE = "https://invent.kde.org/frameworks/bluez-qt"
LICENSE = "LGPL-2.1-or-later & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

DEPENDS += "qtbase"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums

EXTRA_OECMAKE:class-target += "-DUDEV_RULES_INSTALL_DIR=${libdir}/udev/rules.d"

FILES:${PN} += "${libdir}/qml/org/kde/bluezqt/*"

RDEPENDS:${PN} += "bluez5 bluez5-obex"
