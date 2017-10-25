FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://interfaces.static file://interfaces.dhcp"


do_install_append () {
        install -m 0644 ${WORKDIR}/interfaces.static  ${D}${sysconfdir}/network/interfaces.static
        install -m 0644 ${WORKDIR}/interfaces.dhcp ${D}${sysconfdir}/network/interfaces.dhcp

	cp -a ${WORKDIR}/interfaces.static  ${D}${sysconfdir}/network/interfaces
}

PRINC := "${@int(PRINC) + 2}"
