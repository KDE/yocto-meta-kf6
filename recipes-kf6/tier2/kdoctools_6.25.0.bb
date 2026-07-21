# SPDX-FileCopyrightText: 2018-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

SUMMARY = "KDocTools"
DESCRIPTION = "Create documentation from DocBook"
HOMEPAGE = "https://invent.kde.org/frameworks/kdoctools"
LICENSE = "LGPL-2.1-only"

DEPENDS += "docbook-xml-dtd4 \
            docbook-xsl-stylesheets \
            karchive \
            kdoctools-native \
            ki18n \
            liburi-perl \
            libxml2 \
            libxslt \
"

inherit kf6_src
inherit kf6_cmake_framework
inherit gettext
inherit python3native
inherit perlnative
inherit reuse_license_checksums

EXTRA_OECMAKE:class-native = "-DINSTALL_INTERNAL_TOOLS=ON \
                              -DRELOCATABLE_DOCBOOK_FILES=ON \
"

EXTRA_OECMAKE:class-target = "-DMEINPROC6_EXECUTABLE=${STAGING_DIR_NATIVE}/${bindir}/meinproc6 \
                              -DDOCBOOKL10NHELPER_EXECUTABLE=${STAGING_DIR_NATIVE}/${bindir}/docbookl10nhelper \
                              -DCHECKXML6_EXECUTABLE=${STAGING_DIR_NATIVE}/${bindir}/checkXML6 \
                              -DRELOCATABLE_DOCBOOK_FILES=ON \
"

# TODO: this reworks the all-l18n.xml paths to be host-independent a
# better solution is to change this directly in docbookl18nhelper.cpp.
do_compile:append:class-target() {
    sed -i \
          's:${RECIPE_SYSROOT}/usr/share/xml/docbook/xsl-stylesheets:../../../../xml/docbook/xsl-stylesheets:g' \
          ${B}/src/customization/xsl/all-l10n.xml
}

do_compile:append:class-native() {
    sed -i \
          's:${RECIPE_SYSROOT_NATIVE}/usr/share/xml/docbook/xsl-stylesheets:../../../../xml/docbook/xsl-stylesheets:g' \
          ${B}/src/customization/xsl/all-l10n.xml
}

FILES:${PN} += "${datadir}/kf6/kdoctools/customization/* \
                ${datadir}/kf6/kdoctools/customization/*/* \
                ${datadir}/kf6/kdoctools/customization/*/*/* \
"
