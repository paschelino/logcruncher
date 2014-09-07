package info.cosmicsand.logcruncher

public class LogVisitorMock implements LogVisitor {
    private final LogfileStatistics statistics;

    public LogVisitorMock(LogfileStatistics logfileStatistics) {
        this.statistics = logfileStatistics
    }

    @Override
    public LogfileStatistics getStatistics() {
        return statistics
    }
}
