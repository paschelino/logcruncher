package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class RequestBytesCount {
    static final def EMPTY_BYTES_COUNT = new RequestBytesCount(bytesCount: -1L)
    Long bytesCount
}
