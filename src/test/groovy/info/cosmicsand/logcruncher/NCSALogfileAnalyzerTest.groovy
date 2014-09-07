package info.cosmicsand.logcruncher

import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

public class NCSALogfileAnalyzerTest {
    LogfileAnalyzer<NCSALogentry> logfileAnalyzer
    def lowLevelReader
    LogfileStatistics logfileStatistics
    LogVisitor logVisitor

    @Before
    public void setUp() {
        lowLevelReader = new LogIteratorMock<NCSALogentry>()
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
        lowLevelReader.appendEntries(new NCSALogentry())
        assertThat(logfileAnalyzer.analyze(this.logVisitor), is(logfileStatistics))
        assertThat(logfileStatistics.analyzedLogentriesCount(), is(Long.valueOf(1)))
    }
}
