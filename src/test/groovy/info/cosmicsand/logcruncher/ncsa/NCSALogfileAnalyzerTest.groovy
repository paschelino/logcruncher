package info.cosmicsand.logcruncher.ncsa

import info.cosmicsand.logcruncher.LogIteratorMock
import info.cosmicsand.logcruncher.LogVisitorMock
import info.cosmicsand.logcruncher.LogfileStatisticsMock
import info.cosmicsand.logcruncher.contracts.LogVisitor
import info.cosmicsand.logcruncher.contracts.LogfileAnalyzer
import info.cosmicsand.logcruncher.contracts.LogfileStatistics
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

public class NCSALogfileAnalyzerTest {
    LogfileAnalyzer<NCSAExtendedLogentry> logfileAnalyzer
    def lowLevelReader
    LogfileStatistics logfileStatistics
    LogVisitor logVisitor

    @Before
    public void setUp() {
        lowLevelReader = new LogIteratorMock<NCSAExtendedLogentry>()
        logfileAnalyzer = new NCSALogfileAnalyzer(lowLevelReader)
        logfileStatistics = new LogfileStatisticsMock()
        logVisitor = new LogVisitorMock(logfileStatistics)
    }

    @Test
    public void GIVEN_theLogfileIsEmpty_THEN_theStatisticsShowNoRequests() {
        assertThat(logfileAnalyzer.analyze(this.logVisitor), is(this.logfileStatistics))
        assertThat(this.logfileStatistics.analyzedLogentriesCount(), is(Long.valueOf(0)))
    }

    @Test
    public void GIVEN_theLogfileContainsOneEntry_THEN_theAnalyzedCountIs_1() throws Exception {
        lowLevelReader.appendEntries([new NCSAExtendedLogentry()])
        assertThat(logfileAnalyzer.analyze(this.logVisitor), is(logfileStatistics))
        assertThat(logfileStatistics.analyzedLogentriesCount(), is(Long.valueOf(1)))
    }

    @Test
    public void GIVEN_theLogfileContainsSeveralEntries_THEN_theAnalyzedCountIs_2() throws Exception {
        lowLevelReader.appendEntries([new NCSAExtendedLogentry(), new NCSAExtendedLogentry()])
        assertThat(logfileAnalyzer.analyze(this.logVisitor), is(logfileStatistics))
        assertThat(logfileStatistics.analyzedLogentriesCount(), is(Long.valueOf(2)))
    }
}
