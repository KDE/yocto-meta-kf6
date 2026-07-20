# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

# Common source metadata for KDE Gear releases.

SRC_URI = "https://download.kde.org/stable/release-service/${PV}/src/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "${SRC_URI_SHA256SUM_${BPN}}"

SRC_URI_SHA256SUM_baloo-widgets = "665a95086f2913054d5a660494e57de30f877cfe48d60f224b21c31b1ebe3069"
SRC_URI_SHA256SUM_kaccounts-integration = "a449426e849b0562622585d11a12f8b407bbf9cd3a988083b68f17a657727b45"
SRC_URI_SHA256SUM_libkexiv2 = "c5bd5bc894fc7878a6112bad19c78d0978a187151bfb5ac395058ca33090e650"
