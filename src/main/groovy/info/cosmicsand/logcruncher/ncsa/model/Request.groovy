package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Request {
    static final String RAW_REQUEST_VALUE = '"-"'
    static final def EMPTY_REQUEST = new Request(rawRequestValue: RAW_REQUEST_VALUE)
    static final String CAPTURE_EXPRESSION = /^([A-Z]+) ([^:]+):.*/

    @Lazy
    def matcher = {
        rawRequestValue =~ CAPTURE_EXPRESSION
    }()

    @Lazy
    HttpMethod method = {
        matcher.matches() ? HttpMethod.valueOf(matcher[0][1]) : HttpMethod.UNKNOWN_METHOD
    }()

    @Lazy
    HttpProtocol protocol = {
        matcher.matches() ? HttpProtocol.valueOf(matcher[0][2]) : HttpProtocol.http
    }()

    String rawRequestValue

    Request() {
        rawRequestValue = RAW_REQUEST_VALUE
    }

}
