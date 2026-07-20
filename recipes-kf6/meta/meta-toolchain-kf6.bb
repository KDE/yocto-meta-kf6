# SPDX-FileCopyrightText: none
# SPDX-License-Identifier: CC0-1.0

SUMMARY = "KF6 toolchain and SDK"
DESCRIPTION = "Meta package for building an installable KF6 toolchain and SDK"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit populate_sdk populate_sdk_qt6

TOOLCHAIN_TARGET_TASK:remove = "packagegroup-qt6-modules"
TOOLCHAIN_TARGET_TASK:append = " extra-cmake-modules-dev packagegroup-qt6-essentials packagegroup-kf6-full"
