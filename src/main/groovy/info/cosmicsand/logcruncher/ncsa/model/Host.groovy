package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Host {
    static final def LOOPBACK_ADDRESS = new Host(hostValue: InetAddress.getLoopbackAddress())

    InetAddress hostValue
}
