# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2014 Erik Botö <erik.boto@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

# whitelist licenses are all compatible with LGPL-2.0+ and do not add additional restrictions

SUMMARY = "KArchive"
DESCRIPTION = "Qt addon providing access to numerous types of archives"
HOMEPAGE = "https://invent.kde.org/frameworks/karchive"

REUSE_LICENSECHECK_WHITELIST = "LGPL-2.0 LGPL-3.0 LicenseRef-KDE-Accepted-LGPL"
LICENSE = "BSD-2-Clause & LGPL-2.0-or-later"

DEPENDS += "bzip2 qtbase xz zlib"

inherit kf6_src
inherit kf6_cmake_framework
inherit reuse_license_checksums
