# SPDX-FileCopyrightText: 2024 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG:append = " wayland"

SRC_URI += "file://0001-Fix-wayland_scanner-detection-when-cross-compiling.patch"

EXTRA_OECONF += "ac_cv_path_WAYLAND_SCANNER=${STAGING_BINDIR_NATIVE}/wayland-scanner"

do_install:append() {
    # Remove desktop related files, we are only interested in
    # supporting the phonon-vlc-backend.
    rm -rf ${D}${datadir}
}
