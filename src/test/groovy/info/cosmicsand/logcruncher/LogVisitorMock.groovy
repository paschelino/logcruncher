package info.cosmicsand.logcruncher

import info.cosmicsand.logcruncher.contracts.LogVisitor
import info.cosmicsand.logcruncher.contracts.LogfileStatistics

public class LogVisitorMock<LOGENTRY_TYPE> implements LogVisitor<LOGENTRY_TYPE> {
    private final LogfileStatisticsMock statistics;

    public LogVisitorMock(LogfileStatisticsMock logfileStatistics) {
        this.statistics = logfileStatistics
    }

    @Override
    void visit(LOGENTRY_TYPE logentry) {
        statistics.addLogentry(logentry)
    }

    @Override
    public LogfileStatistics getStatistics() {
        return statistics
    }
}
