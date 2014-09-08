package info.cosmicsand.logcruncher

import info.cosmicsand.logcruncher.contracts.LogfileStatistics

public class LogfileStatisticsMock<LOGENTRY_TYPE> implements LogfileStatistics<LOGENTRY_TYPE> {
    long requestCount;

    public LogfileStatisticsMock() {
        this.requestCount = 0L
    }

    public void addLogentry(LOGENTRY_TYPE logentry) {
        this.requestCount++
    }

    @Override
    public Long analyzedLogentriesCount() {
        return Long.valueOf(this.requestCount)
    }
}
