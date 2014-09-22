package info.cosmicsand.logcruncher

import info.cosmicsand.logcruncher.contracts.LogVisitor
import info.cosmicsand.logcruncher.contracts.LogStatistics
import info.cosmicsand.logcruncher.ncsa.NCSAExtendedLogentry
import info.cosmicsand.logcruncher.ncsa.visitors.NCSARequestTotalsVisitor

public class LogVisitorMock extends NCSARequestTotalsVisitor {
    private final LogStatisticsMock statistics;

    public LogVisitorMock(LogStatisticsMock logfileStatistics) {
        this.statistics = logfileStatistics
    }

    @Override
    void visit(NCSAExtendedLogentry logentry) {
        statistics.addLogentry(logentry)
    }

    public LogStatistics getStatistics() {
        return statistics
    }
}
