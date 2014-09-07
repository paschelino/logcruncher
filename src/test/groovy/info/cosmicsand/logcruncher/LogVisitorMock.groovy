package info.cosmicsand.logcruncher

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
