# Copyright (C) 2012-2013 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

COMPATIBLE_MACHINE = "(imx6qarm2|d4400)"
DESCRIPTION = "RRH support libraries and applications"
LICENSE = "GPLv2"
#LIC_FILES_CHKSUM = "file://README;md5=b724cb4ba8409d55cd101c97dfe7a4f1"
LIC_FILES_CHKSUM = "file://README;md5=46712b6288598c5716752eb1ee0e27c3"
SECTION = "rrh-utils"

FSL_SRC_DIR ?= ""
S = '${@base_conditional("FSL_SRC_DIR", "", "${WORKDIR}/git", "${FSL_SRC_DIR}rrh_utils", d)}'

LOCALVERSION = "-dfe"
inherit autotools pkgconfig

PACKAGE_NAME ?= "${PN}"

DEPENDS += "virtual/kernel swig swig-native lua5.1 ncurses readline"

do_configure() {
	type swig > /dev/null 2>&1 && SWIG_LIB=`swig -swiglib` && SWIG_LIB=${SWIG_LIB##${STAGING_DIR_NATIVE}} && export SWIG_LIB || ( bberror "No swig found" && exit 1 )
	echo "SWIG = $(which swig)"
	echo "SWIG_LIB = $(swig -swiglib)"
}


CFLAGS_append = " -g -fPIC "
EXTRA_OEMAKE=" 'CC=${CC}' 'AR=${AR}' 'KERNEL_DIR=${STAGING_KERNEL_DIR}' 'all' "

INHIBIT_PACKAGE_STRIP = "1"
REPENDS_${PN} += "swig lua5.1 ncurses readline"
INSANE_SKIP_${PN} = "ldflags textrel arch"
CONFFILES_${PN} += "${sysconfdir}/config/"
ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
TARGET_CC_ARCH += "${LDFLAGS}"
