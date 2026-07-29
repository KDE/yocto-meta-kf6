# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Extra CMake Modules"
DESCRIPTION = "Extra modules and scripts for CMake"
HOMEPAGE = "https://invent.kde.org/frameworks/extra-cmake-modules"

LICENSE = "BSD-2-Clause & BSD-3-Clause & MIT"

DEPENDS += "cmake-native \
            qtbase-native \
            qttools \
            qttools-native \
"

SRC_URI:append = " file://0001-KDEInstallDirs6-install-metatypes-under-LIBDIR.patch"

require recipes-kf6/frameworks_src.inc
inherit qt6-cmake
inherit reuse_license_checksums

CLEANBROKEN = "1"

EXTRA_OECMAKE:append = " \
    -DBUILD_TESTING=OFF \
"

# nooelint: oelint.vars.insaneskip - some git commit hooks require python, we do not need this
INSANE_SKIP:${PN}-dev = "file-rdeps"

FILES:${PN}-dev += "${datadir}/ECM"
RDEPENDS:${PN}-dev = ""

BBCLASSEXTEND = "native nativesdk"
