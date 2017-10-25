PRINC := "${@int(PRINC) + 1}"

inherit update-alternatives

ALTERNATIVE_NAME_fsl-networking = "ifconfig"
ALTERNATIVE_LINK_fsl-networking = "${base_sbindir}/ifconfig"
ALTERNATIVE_PATH_fsl-networking = "${base_sbindir}/ifconfig.net-tools"
ALTERNATIVE_PRIORITY_fsl-networking = "200"
