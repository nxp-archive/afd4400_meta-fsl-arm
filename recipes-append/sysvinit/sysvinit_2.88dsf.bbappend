FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PR .= "+fsl_networking"

SRC_URI_append = " file://auto-detect-hostname.patch;patchdir=../"
