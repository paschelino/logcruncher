package info.cosmicsand.logcruncher

import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

public class NCSALogfileAnalyzerTest {
    LogfileAnalyzer<NCSALogentry> logfileAnalyzer
    def lowLevelReader

    @Before
    public void setUp() {
        lowLevelReader = new LogReaderMock()
        logfileAnalyzer = new NCSALogfileAnalyzer(lowLevelReader)
    }

    @Test
    public void GIVEN_theLogfileIsEmpty_THEN_theStatisticsShowNoRequests() {
        LogfileStatistics logfileStatistics = new LogfileStatisticsMock()
        LogVisitor logVisitor = new LogVisitorMock(logfileStatistics)
        assertThat(logfileAnalyzer.analyze(logVisitor), is(logfileStatistics))
        assertThat(logfileStatistics.requestCount(), is(Long.valueOf(0)))
    }
}
