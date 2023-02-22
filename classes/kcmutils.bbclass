# Class for recipes using kcmutils host tools
#
# SPDX-FileCopyrightText: 2022 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

DEPENDS:append = " \
    kcmutils \
    kcmutils-native \
"

EXTRA_OECMAKE:append = " -DKF6_HOST_TOOLING=${STAGING_DIR_NATIVE}/${libdir}/cmake"
