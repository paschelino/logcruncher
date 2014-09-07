package info.cosmicsand.logcruncher

import java.math.BigInteger

public class LogfileStatisticsMock<LOGENTRY_TYPE> implements LogfileStatistics<LOGENTRY_TYPE> {
    private long requestCount;

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
