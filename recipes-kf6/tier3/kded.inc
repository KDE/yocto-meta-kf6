# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-only"
PR = "r0"

DEPENDS = " \
    qtbase \
    kconfig \
    kconfig-native \
    kcoreaddons \
    kcoreaddons-native \
    kcrash \
    kdbusaddons \
    kio \
    kauth-native \
    kservice \
"

RDEPENDS:${PN} += " \
    kconfig \
"

require kded_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-kdoctools
inherit reuse_license_checksums

FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${libdir}/systemd/user/plasma-kded6.service \
"

do_configure:prepend() {
    # fix KCONF_UPDATE_EXE definition so it points to the target's filesystem
    sed -i "s#KCONF_UPDATE_EXE=\".*\"#KCONF_UPDATE_EXE=\"${libexecdir}/kf6/kconf_update\"#g" ${S}/src/CMakeLists.txt
}
