# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

# Common source metadata for KDE Gear releases.

SRC_URI = "https://download.kde.org/stable/release-service/${PV}/src/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "${SRC_URI_SHA256SUM_${BPN}}"

SRC_URI_SHA256SUM_baloo-widgets = "b4af5cc65d886ab9d2a807254e11295e585d7cedd993d2b3b78f2f17e3a7f544"
SRC_URI_SHA256SUM_kaccounts-integration = "7b12dc58c368690428ccaa71528f1dfe231eb99fc3a222cf2a8d6cf93dccbb6a"
SRC_URI_SHA256SUM_libkexiv2 = "d50cc3e641d1d9dd6a0f2ea5cd8e0e210e7386f11ba2729b0ade2785400b0e31"
