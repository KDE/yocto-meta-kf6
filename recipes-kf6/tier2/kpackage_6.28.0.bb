# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
# SPDX-FileCopyrightText: 2022 MBition GmbH
# SPDX-FileContributor: Kai Uwe Broulik <kai_uwe.broulik@mbition.io>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Package framework"
DESCRIPTION = "This framework lets applications to manage user installable packages of non-binary assets"
HOMEPAGE = "https://invent.kde.org/frameworks/kpackage"
LICENSE = "LGPL-2.0-or-later & GPL-2.0-or-later"
LICENSE:${PN}-tools = "GPL-2.0-or-later"

DEPENDS += "karchive \
            kcoreaddons \
            kpackage-native \
            qtbase \
"

PACKAGES =+ "${PN}-tools"

FILES:${PN}-tools += "${bindir}/kpackagetool5"

RRECOMMENDS:${BPN} += "${BPN}-tools"

require recipes-kf6/frameworks_src.inc
inherit kf6_cmake_framework
inherit kf6_ki18n
inherit reuse_license_checksums
