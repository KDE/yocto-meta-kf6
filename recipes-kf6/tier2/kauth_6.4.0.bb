# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

require ${PN}.inc
SRC_URI = "https://download.kde.org/stable/frameworks/6.4/kauth-6.4.0.tar.xz"
SRC_URI[sha256sum] = "0598e205dedc670af3a077ba02110a44db2f9d5e55df5003b0fc2490ac2ff1ce"

SRC_URI += "file://0001-Ensure-that-qt-dbus-macros-are-available-with-KAUTH_.patch"
