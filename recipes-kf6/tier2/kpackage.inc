# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
# SPDX-FileCopyrightText: 2022 MBition GmbH
# SPDX-FileContributor: Kai Uwe Broulik <kai_uwe.broulik@mbition.io>
#
# SPDX-License-Identifier: MIT

LICENSE = "LGPL-2.0-or-later & GPL-2.0-or-later"
LICENSE:${PN}-tools = "GPL-2.0-or-later"

PR = "r0"

DEPENDS = " \
    qtbase \
    karchive \
    kcoreaddons \
    kpackage-native \
"

PACKAGES =+ "${PN}-tools"

RRECOMMENDS:${BPN} += "${BPN}-tools"

FILES:${PN}-tools += "\
    ${bindir}/kpackagetool5 \
"

require kpackage_metainfo.inc
inherit kf6-cmake-framework
inherit kf6-ki18n
inherit reuse_license_checksums
