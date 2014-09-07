package info.cosmicsand.logcruncher

import java.math.BigInteger

public interface LogfileStatistics<LOGENTRY_TYPE extends Logentry> {
    Long analyzedLogentriesCount()
}
