# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

require ${PN}.inc

SRC_URI = "git://invent.kde.org/libraries/${BPN}.git;nobranch=1;protocol=https"
SRCREV = "2a09c448ecceef4de5bb0fda7e12b38cfcf0278b"
S = "${WORKDIR}/git"
