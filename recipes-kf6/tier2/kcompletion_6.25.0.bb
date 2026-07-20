# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KCompletion"
DESCRIPTION = "Powerful completion framework, including completion-enabled lineedit and combobox"
HOMEPAGE = "https://invent.kde.org/frameworks/kcompletion"
LICENSE = "BSD-3-Clause & LGPL-2.0-or-later & LGPL-2.1-or-later"

DEPENDS += "kcodecs \
            kconfig \
            kconfig-native \
            kwidgetsaddons \
            qtbase \
"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums
