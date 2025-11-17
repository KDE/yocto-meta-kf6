# kfilemetadata needs poppler with qt6 for pdf support
inherit qt6-cmake
PACKAGECONFIG:append = " qt6"
