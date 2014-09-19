package info.cosmicsand.logcruncher

import info.cosmicsand.logcruncher.contracts.LogStatistics

public class LogStatisticsMock<LOGENTRY_TYPE> implements LogStatistics<LOGENTRY_TYPE> {
    long requestCount;

    public LogStatisticsMock() {
        this.requestCount = 0L
    }

    public void addLogentry(LOGENTRY_TYPE logentry) {
        this.requestCount++
    }

    @Override
    public Long getVisitedLogentriesCount() {
        return Long.valueOf(this.requestCount)
    }
}
