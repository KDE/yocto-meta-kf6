# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018-2019 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-or-later & LGPL-2.1-or-later & MIT"
PR = "r0"

DEPENDS = " \
    kauth-native \
    kconfig \
    kconfig-native \
    kglobalaccel \
    kguiaddons \
    kiconthemes \
    kio \
    knotifications \
    kpackage \
    kpackage-native \
    kwidgetsaddons \
    kwindowsystem \
    libepoxy \
    libxml2-native \
    qtbase \
    qtdeclarative \
"

require kdeclarative_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-ki18n
inherit reuse_license_checksums

FILES:${PN} += " \
    ${libdir}/qml/org/kde \
"

RDEPENDS:${PN} += " \
    qtdeclarative-qmlplugins \
"
