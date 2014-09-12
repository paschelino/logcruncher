package info.cosmicsand.logcruncher.ncsa.model

import de.cosmicsand.webtools.path.Path
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Request {
    static final String RAW_REQUEST_VALUE = '-'
    static final def EMPTY_REQUEST = new Request(rawRequestValue: RAW_REQUEST_VALUE)
    static final String CAPTURE_EXPRESSION = /([^ ]*) ([^:]*):\/{0,2}[^\/]*((?:\/[^\/\?]*)*) .*/

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

    @Lazy
    Path path = {
        matcher.matches() ? new Path(matcher[0][3]) : Path.ROOT
    }()

    @Lazy
    UriQuery query = {
        def splitted = rawRequestValue.split(/\?/)
        def result = UriQuery.EMPTY_QUERY
        if(splitted.length > 1){
            result = new UriQuery(splitted[1].split(/ /)[0])
        }
        result
    }()

    String rawRequestValue

    Request() {
        rawRequestValue = RAW_REQUEST_VALUE
    }

    Request(String rawRequestValue) {
        this.rawRequestValue = rawRequestValue
    }

    @Override
    public String toString() {
        return rawRequestValue;
    }
}
