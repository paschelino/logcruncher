package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Request {
    static final def EMPTY_REQUEST = new Request(rawRequestValue: '"-"')
    String rawRequestValue
}
