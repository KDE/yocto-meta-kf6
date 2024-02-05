# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

SUMMARY = "All meta-kf6 packages"
DESCRIPTION = "This packagegroup is pimarily meant for release testing."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PACKAGE_ARCH = ""
REQUIRED_DISTRO_FEATURES = "wayland x11"
PV = "5.249.0"

inherit packagegroup features_check

RDEPENDS:${PN} += " \
kwindowsystem \
kconfig \
attica \
kplotting \
karchive \
kuserfeedback \
kquickcharts \
modemmanager-qt \
prison \
sonnet \
breeze-icons \
bluez-qt \
kholidays \
threadweaver \
kitemmodels \
kcodecs \
kglobalaccel \
solid \
kcalendarcore \
kitemviews \
kdnssd \
ktexttemplate \
networkmanager-qt \
syntax-highlighting \
kcoreaddons \
kdbusaddons \
kidletime \
kirigami \
kwidgetsaddons \
extra-cmake-modules \
ki18n \
kguiaddons \
kservice \
knotifyconfig \
qqc2-desktop-style \
krunner \
kdeclarative \
kdesu \
ktexteditor \
kwallet \
knewstuff \
ksvg \
kded \
purpose \
kparts \
kbookmarks \
kconfigwidgets \
ktextwidgets \
baloo \
kio \
kiconthemes \
kdav \
kcmutils \
kxmlgui \
frameworkintegration \
kcrash \
kcolorscheme \
kfilemetadata \
knotifications \
kauth \
kjobwidgets \
kunitconversion \
kcompletion \
kstatusnotifieritem \
kpeople \
kcontacts \
kpackage \
kpty \
kimageformats \
syndication \
kdoctools \
"
