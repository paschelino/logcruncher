package info.cosmicsand.logcruncher.contracts

public interface LogfileStatistics<LOGENTRY_TYPE extends Logentry> {
    Long analyzedLogentriesCount()
}
