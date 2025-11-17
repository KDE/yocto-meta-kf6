SUMMARY = "Accounts management library for GLib applications"
DESCRIPTION = "This project is a library for managing accounts which can be used from GLib \
applications. It is part of the accounts-sso project."
HOMEPAGE = "https://gitlab.com/accounts-sso/libaccounts-glib"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

inherit meson pkgconfig gobject-introspection vala

SRC_URI = "git://gitlab.com/accounts-sso/libaccounts-glib.git;branch=master;protocol=https"
SRCREV = "c823beed760ab2428f3355db06f48c4b5c14c62e"

S = "${WORKDIR}/git"

DEPENDS = " \
    glib-2.0 \
    libxml2 \
    sqlite3 \
"

EXTRA_OEMESON = " \
    -Ddocs=false \
    -Dtests=false \
"

FILES:${PN} += " \
    ${datadir}/xml \
    ${datadir}/dbus-1 \
    ${datadir}/gettext \
"
