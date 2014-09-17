package info.cosmicsand.logcruncher.ncsa.model

import de.cosmicsand.webtools.path.Path
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class RequestType {
    static final RequestType NONE = new RequestType(HttpMethod.UNKNOWN_METHOD, HttpProtocol.undefined, null)

    final HttpMethod method
    final HttpProtocol protocol
    final Path path

    RequestType(HttpMethod method, HttpProtocol protocol, Path path) {
        this.method = method
        this.protocol = protocol
        this.path = path
    }

    @Override
    public String toString() {
        return "RequestType{" +
                "method=" + method +
                ", protocol=" + protocol +
                ", path=" + path +
                '}';
    }
}
