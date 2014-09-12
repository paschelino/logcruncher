package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class UriQuery {
    static def EMPTY_QUERY = new UriQuery()

    def query = ''

    UriQuery(String query) {
        this.query = query
    }

    UriQuery() {
        this.query = ''
    }

    @Override
    public String toString() {
        return query;
    }
}
