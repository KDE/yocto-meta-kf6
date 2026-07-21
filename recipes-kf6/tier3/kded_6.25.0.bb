# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KDE Daemon"
DESCRIPTION = "Central daemon of KDE work spaces"
HOMEPAGE = "https://invent.kde.org/frameworks/kded"
LICENSE = "LGPL-2.0-only"

DEPENDS += "kauth-native \
            kconfig \
            kconfig-native \
            kcoreaddons \
            kcoreaddons-native \
            kcrash \
            kdbusaddons \
            kio \
            kservice \
            qtbase \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_kdoctools
inherit reuse_license_checksums

FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/systemd/user/plasma-kded6.service"

do_configure:prepend() {
    # fix KCONF_UPDATE_EXE definition so it points to the target's filesystem
    sed -i "s#KCONF_UPDATE_EXE=\".*\"#KCONF_UPDATE_EXE=\"${libexecdir}/kf6/kconf_update\"#g" ${S}/src/CMakeLists.txt
}

RDEPENDS:${PN} += "kconfig"
