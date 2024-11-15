# SPDX-FileCopyrightText: 2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

inherit qt6-cmake

do_install:append() {
    # imported targets may leak full paths to system targets
    if [ "0" -ne $(find ${D} \( -name "*.cmake" \) | wc -l) ]; then
        find ${D} \( -name "*.cmake" \) -exec \
            sed -i -e 's|${RECIPE_SYSROOT}/usr|\$\{_IMPORT_PREFIX\}|g' \
                {} \;
    fi
    if [ "0" -ne $(find ${D} \( -name "*.pc" \) | wc -l) ]; then
        find ${D} \( -name "*.pc" \) -exec \
            sed -i -e 's|-I${RECIPE_SYSROOT}/usr/|-I\$\{prefix\}/|g' \
                {} \;
    fi
}
