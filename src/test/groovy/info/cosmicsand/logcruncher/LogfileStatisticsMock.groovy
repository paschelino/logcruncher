package info.cosmicsand.logcruncher

import java.math.BigInteger

public class LogfileStatisticsMock implements LogfileStatistics {
    private long requestCount;

    public LogfileStatisticsMock() {
        this.requestCount = 0L
    }

    public void addRequest(Logentry logentry) {
        this.requestCount++
    }

    @Override
    public Long requestCount() {
        return Long.valueOf(this.requestCount)
    }
}
