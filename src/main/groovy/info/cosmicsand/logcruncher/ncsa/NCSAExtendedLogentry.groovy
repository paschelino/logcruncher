package info.cosmicsand.logcruncher.ncsa

import groovy.transform.EqualsAndHashCode
import info.cosmicsand.logcruncher.contracts.Logentry
import info.cosmicsand.logcruncher.ncsa.model.Host
import info.cosmicsand.logcruncher.ncsa.model.HttpStatus
import info.cosmicsand.logcruncher.ncsa.model.Referer
import info.cosmicsand.logcruncher.ncsa.model.Request
import info.cosmicsand.logcruncher.ncsa.model.RequestBytesCount
import info.cosmicsand.logcruncher.ncsa.model.RequestDate
import info.cosmicsand.logcruncher.ncsa.model.User
import info.cosmicsand.logcruncher.ncsa.model.UserAgent
import info.cosmicsand.logcruncher.ncsa.model.UserIdentifierAccordingRFC931

@EqualsAndHashCode
public class NCSAExtendedLogentry implements Logentry {
    static final String RAW_DUMB_ENTRY = "- - - [-] \"-\" - - \"-\" \"-\""
    static final NCSAExtendedLogentry DUMB_ENTRY = new NCSAExtendedLogentry(RAW_DUMB_ENTRY)

    static final String CAPTURE_EXPRESSION = /.* \"(.+)\" .*/

    @Lazy
    def matcher = {
        rawLogEntry =~ CAPTURE_EXPRESSION
    }()

    Host remoteHost = Host.LOOPBACK_ADDRESS
    UserIdentifierAccordingRFC931 userIdentifierAccordingRFC931 = UserIdentifierAccordingRFC931.EMPTY_USER_ID
    User user = User.EMPTY_USER
    RequestDate date = RequestDate.EMPTY_DATE

    @Lazy
    Request request = {
        def startIndex = rawLogEntry.indexOf('"')
        def rawRequest = rawLogEntry.substring(startIndex + 1)
        new Request(rawRequest.substring(0, rawRequest.indexOf('"')))
    }()

    HttpStatus httpStatus = HttpStatus.EMPTY_STATUS
    RequestBytesCount bytesCount = RequestBytesCount.EMPTY_BYTES_COUNT
    Referer referer = Referer.EMPTY_REFERER
    UserAgent userAgent = UserAgent.EMPTY_USER_AGENT

    String rawLogEntry

    NCSAExtendedLogentry(String rawLogEntry) {
        this.rawLogEntry = rawLogEntry
    }

    NCSAExtendedLogentry() {
        this(RAW_DUMB_ENTRY)
    }

    @Override
    String toString() {
        rawLogEntry
    }
}
