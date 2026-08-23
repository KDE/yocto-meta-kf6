# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KImageFormats"
DESCRIPTION = "Plugins to allow QImage to support extra file formats"
HOMEPAGE = "https://invent.kde.org/frameworks/kimageformats"
LICENSE = "BSD-2-Clause & LGPL-2.0-or-later & LGPL-2.1-or-later & (LGPL-2.1-only | LGPL-3.0-only | LicenseRef-KDE-Accepted-LGPL)"

DEPENDS += "karchive \
            libavif \
            qtbase \
"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit reuse_license_checksums

FILES:${PN}-dbg += "${libdir}/plugins/imageformats/.debug/*.so"

FILES:${PN} += "${libdir}/plugins/imageformats/*.so \
                ${datadir}/kservices6/qimageioplugins/*.desktop \
"
