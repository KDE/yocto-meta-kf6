# SPDX-FileCopyrightText: 2024 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

PACKAGECONFIG:append = " wayland"

do_install:append() {
    # Remove desktop related files, we are only interested in
    # supporting the phonon-vlc-backend.
    rm -rf ${D}${datadir}
}
