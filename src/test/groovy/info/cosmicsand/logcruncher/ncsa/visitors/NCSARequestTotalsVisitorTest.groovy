package info.cosmicsand.logcruncher.ncsa.visitors

import info.cosmicsand.logcruncher.contracts.LogVisitor
import info.cosmicsand.logcruncher.contracts.LogStatistics
import info.cosmicsand.logcruncher.ncsa.NCSAExtendedLogentry
import info.cosmicsand.logcruncher.ncsa.contracts.NCSALogStatistics
import org.junit.Before
import org.junit.Ignore
import org.junit.Test


import static org.hamcrest.Matchers.*
import static org.junit.Assert.assertThat

class NCSARequestTotalsVisitorTest {
    private NCSARequestTotalsVisitor visitor

    @Before
    public void setUp() throws Exception {
        visitor = new NCSARequestTotalsVisitor()
    }

    @Test
    public void itHasToImplement_LogVisitor() throws Exception {
        assertThat(visitor, is(instanceOf(LogVisitor.class)))
    }

    @Test
    public void itHasToImplement_LogStatistics() throws Exception {
        assertThat(visitor, is(instanceOf(NCSALogStatistics.class)))
    }

    @Test
    public void Given_noLogEntry_THEN_theStatisticsAreEmpty() throws Exception {
        assertThat(visitor.getVisitedLogentriesCount(), is(0L))
    }

    @Test
    public void GIVEN_oneLogEntry_THEN_oneHasBeenAnalyzed() throws Exception {
        visitor.visit(NCSAExtendedLogentry.DUMB_ENTRY)
        assertThat(visitor.getVisitedLogentriesCount(), is(1L))
    }

    @Test
    public void GIVEN_severalLogEntries_THEN_severalHaveBeenAnalyzed() throws Exception {
        visitor.visit(NCSAExtendedLogentry.DUMB_ENTRY)
        visitor.visit(NCSAExtendedLogentry.DUMB_ENTRY)
        assertThat(visitor.getVisitedLogentriesCount(), is(2L))
    }

    @Test
    public void GIVEN_noLogEntry_THEN_theStatisticsCountZero() throws Exception {
        assertThat(visitor.getRequestCount(NCSAExtendedLogentry.DUMB_ENTRY.request.type), is(0L))
    }

    @Test
    public void GIVEN_oneLogEntry_THEN_theStatisticsCountOne() throws Exception {
        visitor.visit(NCSAExtendedLogentry.DUMB_ENTRY)
        assertThat(visitor.getRequestCount(NCSAExtendedLogentry.DUMB_ENTRY.request.type), is(1L))
    }

    @Test
    public void GIVEN_severalLogEntries_THEN_theStatisticsCountsThem() throws Exception {
        visitor.visit(NCSAExtendedLogentry.DUMB_ENTRY)
        visitor.visit(NCSAExtendedLogentry.DUMB_ENTRY)
        assertThat(visitor.getRequestCount(NCSAExtendedLogentry.DUMB_ENTRY.request.type), is(2L))
    }

    @Test
    public void GIVEN_twoEntriesOfDifferentRequestTypes_THEN_countEachTypeOnce() throws Exception {
        visitor.visit(NCSAExtendedLogentry.DUMB_ENTRY)

        def dateTime = "13/Feb/1976:09:10:11 +0200"
        def rawRequest = "GET http://www.example.org/?key=value HTTP/1.1"
        def rawEntry = "- - - [$dateTime] \"$rawRequest\" - - \"-\" \"-\""
        def logentry = new NCSAExtendedLogentry(rawEntry)
        visitor.visit(logentry)
        assertThat(visitor.getRequestCount(NCSAExtendedLogentry.DUMB_ENTRY.request.type), is(1L))
        assertThat(visitor.getRequestCount(logentry.request.type), is(1L))
    }

    @Test
    public void ignoreNullValues() throws Exception {
        visitor.visit(null)
        assertThat(visitor.getVisitedLogentriesCount(), is(0L))
    }
}
