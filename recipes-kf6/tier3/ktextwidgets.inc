# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.1-or-later & (LGPL-2.0-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"
PR = "r0"

DEPENDS = " \
    qtbase \
    qtspeech \
    kcompletion \
    kconfig \
    kconfig-native \
    kconfigwidgets \
    kcoreaddons-native \
    kauth-native \
    kservice \
    kwidgetsaddons \
    sonnet \
"

require ktextwidgets_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-ki18n
inherit reuse_license_checksums
