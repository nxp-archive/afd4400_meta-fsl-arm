# Copyright (C) 2012-2013 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

COMPATIBLE_MACHINE = "(imx6qarm2|d4400)"
DESCRIPTION = "Freescale Community mainline based Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
DEPENDS += "lzop-native"

PROVIDES += "virtual/kernel"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc

FSL_SRC_DIR ?= ""
S = '${@base_conditional("FSL_SRC_DIR", "", "${WORKDIR}/git", "${FSL_SRC_DIR}linux", d)}'
LOCALVERSION = "-dfe"

DEFAULT_PREFERENCE_imx6qarm2 = "1"
DEFAULT_PREFERENCE_d4400 = "1"

do_configure_prepend() {
# copy desired defconfig so we pick it up for the real kernel_do_configure
	cp ${KERNEL_DEFCONFIG} ${B}/.config
}
