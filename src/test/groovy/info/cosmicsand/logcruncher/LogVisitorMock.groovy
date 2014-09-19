package info.cosmicsand.logcruncher

import info.cosmicsand.logcruncher.contracts.LogVisitor
import info.cosmicsand.logcruncher.contracts.LogStatistics

public class LogVisitorMock<LOGENTRY_TYPE> implements LogVisitor<LOGENTRY_TYPE> {
    private final LogStatisticsMock statistics;

    public LogVisitorMock(LogStatisticsMock logfileStatistics) {
        this.statistics = logfileStatistics
    }

    @Override
    void visit(LOGENTRY_TYPE logentry) {
        statistics.addLogentry(logentry)
    }

    public LogStatistics getStatistics() {
        return statistics
    }
}
