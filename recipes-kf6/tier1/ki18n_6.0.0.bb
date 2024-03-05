# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

require ${PN}.inc
SRC_URI = " \
    https://download.kde.org/stable/frameworks/6.0/ki18n-6.0.0.tar.xz \
    file://0001-Fix-compilation-with-GCC-9.patch \
"
SRC_URI[sha256sum] = "15cbfb73ef1d3954d6206755b6e6a9c86ea27be4b4db0c843d38494851bcc354"

