package info.cosmicsand.logcruncher.ncsa.model

enum HttpMethod {
    GET, POST, PUT, DELETE, HEAD, TRACE, OPTIONS, CONNECT,
    PATCH, //http://tools.ietf.org/html/rfc5789
    PROPFIND, PROPPATCH, MKCOL, COPY, MOVE, LOCK, UNLOCK, //http://webdav.org/

    UNKNOWN_METHOD
}
