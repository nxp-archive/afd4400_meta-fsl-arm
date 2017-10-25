PR_append = "+fsl_networking"

FILESEXTRAPATHS_prepend := "${THISDIR}/busybox-1.20.2:"

SRC_URI_append = " file://defconfig-fsl"

do_configure_prepend () {
        cp ${WORKDIR}/defconfig-fsl ${WORKDIR}/defconfig
}
