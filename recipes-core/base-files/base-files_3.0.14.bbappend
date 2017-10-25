FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += " file://fstab"
SRC_URI_append += " file://mysyslog.conf"


do_install_append () {

        install -m 0644 ${WORKDIR}/fstab  ${D}${sysconfdir}/fstab
        install -m 0644 ${WORKDIR}/mysyslog.conf  ${D}${sysconfdir}/mysyslog.conf
}

PRINC := "${@int(PRINC) + 2}"
