package info.cosmicsand.logcruncher.ncsa

import info.cosmicsand.logcruncher.ncsa.model.Host
import info.cosmicsand.logcruncher.ncsa.model.HttpStatus
import info.cosmicsand.logcruncher.ncsa.model.Referer
import info.cosmicsand.logcruncher.ncsa.model.Request
import info.cosmicsand.logcruncher.ncsa.model.RequestBytesCount
import info.cosmicsand.logcruncher.ncsa.model.RequestDate
import info.cosmicsand.logcruncher.ncsa.model.User
import info.cosmicsand.logcruncher.ncsa.model.UserAgent
import info.cosmicsand.logcruncher.ncsa.model.UserIdentifierAccordingRFC931
import org.junit.Test


import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.*

class NCSAExtendedLogentryTest {

    public static final String RAW_DUMB_ENTRY = "- - - [-] \"-\" - - \"-\" \"-\""

    @Test
    public void GIVEN_allEntryItemsAreEmpty_THEN_equalToThe_DUMB_ENTRY( ) throws Exception {
        def logentry = new NCSAExtendedLogentry(RAW_DUMB_ENTRY)
        assertThat(logentry.remoteHost, is(Host.LOOPBACK_ADDRESS))
        assertThat(logentry.userIdentifierAccordingRFC931, is(UserIdentifierAccordingRFC931.EMPTY_USER_ID))
        assertThat(logentry.user, is(User.EMPTY_USER))
        assertThat(logentry.date, is(RequestDate.EMPTY_DATE))
        assertThat(logentry.request, is(Request.EMPTY_REQUEST))
        assertThat(logentry.httpStatus, is(HttpStatus.EMPTY_STATUS))
        assertThat(logentry.bytesCount, is(RequestBytesCount.EMPTY_BYTES_COUNT))
        assertThat(logentry.referer, is(Referer.EMPTY_REFERER))
        assertThat(logentry.userAgent, is(UserAgent.EMPTY_USER_AGENT))

        assertThat(logentry, is(NCSAExtendedLogentry.DUMB_ENTRY))
    }

    @Test
    public void GIVEN_aDumbLogentry_THEN_toStringReturnsTheRawValue() throws Exception {
        assertThat(new NCSAExtendedLogentry().toString(), is(RAW_DUMB_ENTRY))
    }
}
