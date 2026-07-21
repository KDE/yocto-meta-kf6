# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KXMLGUI"
DESCRIPTION = "Framework for managing menu and toolbar actions"
HOMEPAGE = "https://invent.kde.org/frameworks/kxmlgui"
LICENSE = "LGPL-2.1-only"

DEPENDS += "kauth-native \
            kconfig \
            kconfig-native \
            kconfigwidgets \
            kcoreaddons \
            kglobalaccel \
            kiconthemes \
            kitemviews \
            kwidgetsaddons \
            kwindowsystem \
            qtbase \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums

EXTRA_OECMAKE += "-DBUILD_PYTHON_BINDINGS=OFF"
