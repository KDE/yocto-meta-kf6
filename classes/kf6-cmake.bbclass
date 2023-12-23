# SPDX-FileCopyrightText: 2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

inherit qt6-cmake

do_install:append() {
    # imported targets may leak full paths to system targets
    if [ "0" -ne $(find ${D} \( -name "*.cmake" \) | grep "${RECIPE_SYSROOT}/usr" | wc -l) ]; then
        find ${D} \( -name "*.cmake" \) -exec \
            sed -i -e 's|${RECIPE_SYSROOT}/usr|\$\{_IMPORT_PREFIX\}|g' \
                {} \;
    fi
}
