# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"
PR = "r0"

require oxygen-icons_metainfo.inc
inherit kf6-cmake-framework

FILES:${PN} += " \
    ${datadir}/icons/oxygen/index.theme \
    ${datadir}/icons/oxygen/base/*/*/*.png \
"
