# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

# Common source metadata for KDE Gear releases.

SRC_URI = "https://download.kde.org/stable/release-service/${PV}/src/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "${SRC_URI_SHA256SUM_${BPN}}"

SRC_URI_SHA256SUM_baloo-widgets = "445efd6a8e9aafcd2a86dd47ecc5459c39054303ba650c898893cde8db2f5bf6"
SRC_URI_SHA256SUM_kaccounts-integration = "1d8b11fb01151f4a44cae517bb21b10740c130856b99ab42cefd72d4945d62ca"
SRC_URI_SHA256SUM_libkexiv2 = "a0492337374ae19d9fa73a605451ba10536cfbf53108af7e9bf77defbe7bcd00"
