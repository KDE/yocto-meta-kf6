# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

require ${PN}.inc

# NOTE: this is an unreleased selected git hash, needed for compatibility with Plasma 5.90.0
SRCREV = "2ead53e10b584e7c2ffd204f69457dedebf640ce"
SRC_URI = "git://invent.kde.org/libraries/${BPN}.git;nobranch=1;protocol=https"
S = "${WORKDIR}/git"
