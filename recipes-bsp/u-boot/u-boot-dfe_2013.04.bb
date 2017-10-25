require recipes-bsp/u-boot/u-boot.inc

COMPATIBLE_MACHINE = "(imx6qarm2|d4400)"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

DEPENDS_mxs += "elftosb-native"

PROVIDES += "u-boot"

FSL_SRC_DIR ?= ""
S = '${@base_conditional("FSL_SRC_DIR", "", "${WORKDIR}/git", "${FSL_SRC_DIR}u-boot", d)}'

PACKAGE_ARCH = "${MACHINE_ARCH}"
DEFAULT_PREFERENCE_imx6qarm2 = "1"
DEFAULT_PREFERENCE_d4400 = "1"
