<!--
  SPDX-FileCopyrightText: 2014 Johan Thelin <johan.thelin@pelagicore.com>
  SPDX-FileCopyrightText: 2018 Volker Krause <vkrause@kde.org>
  SPDX-FileCopyrightText: 2019 Hannah Kiekens <hannahkiekens@gmail.com>
  SPDX-FileCopyrightText: 2020 Andreas Cord-Landwehr <cordlandwehr@kde.org>
  
  SPDX-License-Identifier: MIT
-->

# yocto-meta-kf6

KF6, or KDE Frameworks 6, are a set of Qt add-on modules developed by the KDE
project. They extend and improve on Qt.

## Links

* Project page: https://invent.kde.org/packaging/yocto-meta-kf6
* Discussion room: https://matrix.to/#/#yocto:kde.org
* KF6 apidocs: http://api.kde.org/frameworks-api/frameworks5-apidocs/

## Dependencies

yocto-meta-kf6 layer depends on:

* URI: git://code.qt.io/yocto/meta-qt6.git
  * branch: 6.4.0 or newer

* URI:  git://git.yoctoproject.org/poky
  * branch: dunfell, gatesgarth, hardknott, honister, kirkstone, langdale or master

* URI: git://git.openembedded.org/meta-openembedded
  * layers: meta-oe, meta-networking
  * branch: dunfell, gatesgarth, hardknott, honister, kirkstone, langdale or master


## Getting started

Add the kf6 layer and dependencies to bblayers.conf:
```
BBLAYERS ?= " \
  /path/to/project/poky/meta \
  /path/to/project/poky/meta-poky \
  /path/to/project/poky/meta-yocto-bsp \
  /path/to/project/meta-raspberrypi \
  /path/to/project/meta-openembedded/meta-networking \
  /path/to/project/meta-openembedded/meta-oe \
  /path/to/project/meta-qt6 \
  /path/to/project/yocto-meta-kf6 \
  "
```

Add polkit to DISTRO_FEATURES in local.conf
```
DISTRO_FEATURES:append = " polkit"
```
