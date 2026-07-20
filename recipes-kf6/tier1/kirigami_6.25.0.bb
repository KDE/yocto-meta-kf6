# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Kirigami"
DESCRIPTION = "A QtQuick based components set"
HOMEPAGE = "https://invent.kde.org/frameworks/kirigami"
LICENSE = "LGPL-2.0-or-later"

DEPENDS += "qtdeclarative qtsvg"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/qml/org/kde/kirigami/* \
                ${libdir}/qml/org/kde/kirigami.2/* \
"

RDEPENDS:${PN} += "qtdeclarative-qmlplugins"
