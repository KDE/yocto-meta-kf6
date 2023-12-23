# SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
# SPDX-FileCopyrightText: 2016 Sébastien Taylor <sebastien@au-zone.com>
# SPDX-FileCopyrightText: 2017-2019 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

inherit kf6-cmake
inherit pkgconfig
inherit mime-xdg

EXTRA_OECMAKE:append:class-native = " \
    -DOE_KF6_PATH_HOST_ROOT=${STAGING_DIR_HOST} \
    -DBUILD_TESTING=OFF \
    -DBUILD_DESIGNERPLUGIN=OFF \
    -DBUILD_WITH_QT6=ON \
    -DQT_MAJOR_VERSION=6 \
"

EXTRA_OECMAKE:append:class-target = " \
    -DOE_KF6_PATH_HOST_ROOT=${STAGING_DIR_HOST} \
    -DBUILD_TESTING=OFF \
    -DKF6_HOST_TOOLING=${STAGING_LIBDIR_NATIVE}/cmake \
    -DBUILD_DESIGNERPLUGIN=OFF \
    -DBUILD_WITH_QT6=ON \
    -DQT_MAJOR_VERSION=6 \
"

DEPENDS:append = " \
    extra-cmake-modules \
    qttools-native \
"

# don't bother with translations for host tools
do_configure:prepend:class-native() {
    rm -rf ${S}/po
}

do_compile:prepend() {
    export XDG_DATA_DIRS=${STAGING_DATADIR}:$XDG_DATA_DIRS
    export LD_LIBRARY_PATH=${STAGING_LIBDIR_NATIVE}:$LD_LIBRARY_PATH
}

# This function is rather offensive, but it seems to work:
# look into _usr or Export subpathes (depending on CMake version) for CMake target files inside
# the build directory an rewrite absolut pathes to have a OE_KF6_PATH_HOST_ROOT prefix variable
do_install:prepend() {
    if [ "0" -ne $(find . -name \*.cmake | grep '_usr\|Export' | wc -l) ]; then
        sed -i 's/\"\/usr\//\"\$\{OE_KF6_PATH_HOST_ROOT\}\/usr\//g' $(find . -name "*.cmake" | grep '_usr\|Export')
        sed -i 's/\;\/usr\//\;\$\{OE_KF6_PATH_HOST_ROOT\}\/usr\//g' $(find . -name "*.cmake" | grep '_usr\|Export')
    fi
}

BBCLASSEXTEND = "native nativesdk"

FILES:${PN}:append = " \
    ${datadir}/dbus-1/services/*.service \
    ${datadir}/dbus-1/system-services/*.service \
    ${datadir}/dbus-1/system.d/*.conf \
    ${datadir}/knotifications6/*.notifyrc \
    ${datadir}/kservices6/*.desktop \
    ${datadir}/kservices6/*.protocol \
    ${datadir}/kservicetypes6/*.desktop \
    ${datadir}/kservices6/*.desktop \
    ${datadir}/polkit-1/actions/*.policy \
    ${datadir}/mime/packages/kde6.xml \
    ${libdir}/qml/org/kde/* \
"

# TODO "${datadir}/kdevappwizard/templates/*.tar.bz2" is deprecated, remove when all frameworks are ported away
FILES:${PN}-dev:append = " \
    ${datadir}/dbus-1/interfaces/*.xml \
    ${datadir}/kdevappwizard/templates/*.tar.bz2 \
    ${datadir}/kdevfiletemplates/templates/*.tar.bz2 \
    ${datadir}/qlogging-categories6 \
    ${libdir}/cmake \
    ${libdir}/plugins/designer/*.so \
    ${prefix}/mkspecs/modules/qt_*.pri \
"
