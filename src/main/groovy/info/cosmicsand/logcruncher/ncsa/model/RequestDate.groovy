package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

import java.text.SimpleDateFormat

@EqualsAndHashCode
class RequestDate {
    static final def EMPTY_DATE = new RequestDate(rawDate: "-")
    static final def DATE_PARSER = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z")
    def rawDate

    @Lazy
    Date parsedDate = {
        DATE_PARSER.parse(rawDate)
    }()

    RequestDate() {
        this.rawDate = "-"
    }

    RequestDate(String rawDate) {
        this.rawDate = rawDate
    }
}
