# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

# Common source metadata for KDE Gear releases.

SRC_URI = "https://download.kde.org/stable/release-service/${PV}/src/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "${SRC_URI_SHA256SUM_${BPN}}"

SRC_URI_SHA256SUM_baloo-widgets = "fa5288d216d3ed9ed0926385dbc0b266b60317a60c231a6dccaff4bcd810d9fc"
SRC_URI_SHA256SUM_kaccounts-integration = "efdf9f14f7fa917863effd47b0c7ebd0b49687e9205049ff8cb868405f16334c"
SRC_URI_SHA256SUM_libkexiv2 = "dd5ddbf107dd9a51454ae83b0537ca80ce31e65da649c0a8db745e356d0d0064"
