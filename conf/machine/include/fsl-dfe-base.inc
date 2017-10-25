# Provides the i.MX common settings
include conf/machine/include/soc-family.inc
IMAGE_CLASSES = "image_types_uboot"


# Disable perf features as 2.6.35.3 fail to build otherwise
PERF_FEATURES_ENABLE = ""



IMAGE_FEATURES += "dev-pkgs"
# Ship kernel modules
MACHINE_EXTRA_RRECOMMENDS = "kernel-modules"

JFFS2_ERASEBLOCK = "0x20000"
EXTRA_IMAGECMD_jffs2 = "--pad --little-endian -s 0x400 --eraseblock=${JFFS2_ERASEBLOCK} --no-cleanmarkers"

# Extra udev rules
MACHINE_EXTRA_RRECOMMENDS += "udev-extraconf rrh-utils"

EXTRA_IMAGEDEPENDS = "u-boot"

IMAGE_FSTYPES = "ext2.gz"
SERIAL_CONSOLE = "115200 ttymxc3"

KERNEL_IMAGETYPE = "zImage"
