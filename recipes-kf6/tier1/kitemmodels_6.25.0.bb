# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KItemModels"
DESCRIPTION = "Set of item models extending the Qt model-view framework"
HOMEPAGE = "https://invent.kde.org/frameworks/kitemmodels"
LICENSE = "LGPL-2.0-or-later & (LGPL-2.1-only | LGPL-3.0-only)"

DEPENDS += "qtbase"

inherit kf6
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN} += "${libdir}/qml/org/kde/kitemmodels/qmldir \
                ${libdir}/qml/org/kde/kitemmodels/libitemmodelsplugin.so \
"
