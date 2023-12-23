# SPDX-FileCopyrightText: 2023 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

inherit qt6-cmake

do_compile:append() {
    # Rewrite source code location comments in generated files to only contain the relative source folder path.
    # examples:
    # - qdbusxml2cpp: "* Command line was: qdbusxml2cpp -m -p jobviewserverinterface ${S}/kjobwidgets-5.247.0/src/org.kde.JobViewServer.xml"
    # - rcc: "// ${B}/src/.qsb/shadowedrectangle.vert.qsb
    # - qtwaylandscanner: "// source file is ${RECIPE_SYSROOT}/usr/share/plasma-wayland-protocols/keystate.xml"
    if [ "0" -ne $(find ${B} \( -name "*.h" -or -name "*.cpp" \) | wc -l) ]; then
        find ${B} \( -name "*.h" -or -name "*.cpp" \) -exec \
            sed -i -e 's| ${S}| |g' \
            sed -i -e 's| ${B}| |g' \
            sed -i -e 's| ${RECIPE_SYSROOT}| |g' \
            {} \;
    fi
}

do_install:append() {
    # imported targets may leak full paths to system targets
    if [ "0" -ne $(find ${D} \( -name "*.cmake" \) | wc -l) ]; then
        find ${D} \( -name "*.cmake" \) -exec \
            sed -i -e 's|${RECIPE_SYSROOT}/usr|\$\{_IMPORT_PREFIX\}|g' \
                {} \;
    fi
}
