# Copyright (C) 2011 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

COMPATIBLE_MACHINE = "d4400"
DESCRIPTION = "Generate D4400 FIT image"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://kernel_fit.its;md5=0b4e6221c868da555561e5a2aa9120aa"
SRC_URI = "file://kernel_fit.its"
DEPENDS += "virtual/kernel rrh-utils core-image-minimal"

S = "${WORKDIR}"

do_install() {

	# copy required files
	install -m 0644 ${TMPDIR}/deploy/images/core-image-minimal-d4400.ext2.gz ${S}/rootfs.ext2.gz
	install -m 0644 ${TMPDIR}/deploy/images/zImage-d4400.bin ${S}/zImage
	install -m 0644 ${TMPDIR}/deploy/images/zImage-d4400-evb.dtb ${S}/d4400-evb.dtb

	# Generate kernel_fit.itb image
	mkimage -f kernel_fit.its kernel_fit.itb

	#copy kernel_fit.itb to tmp/deploy/images
	install -m 0644 ${S}/kernel_fit.itb ${TMPDIR}/deploy/images/kernel_fit.itb

	# clean up
	rm -f {S}/zImage
	rm -f {S}/d4400-evb.d4400
	rm -f {S}/rootfs.ext2.gz.u-boot
	rm -f {S}/rootfs.ext2.gz
	rm -f {S}/kernel_fit.itb
}
