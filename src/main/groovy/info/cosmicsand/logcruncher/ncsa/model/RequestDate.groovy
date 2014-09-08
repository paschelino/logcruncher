package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class RequestDate {
    static final def EMPTY_DATE = new RequestDate(rawDate: -1L)
    Long rawDate
}
