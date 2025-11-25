# SPDX-FileCopyrightText: 2025 Marc Ferland <marc.ferland@sonatest.com>
#
# SPDX-License-Identifier: MIT

# kfilemetadata needs poppler with qt6 for pdf support
inherit qt6-cmake
PACKAGECONFIG:append = " qt6"
