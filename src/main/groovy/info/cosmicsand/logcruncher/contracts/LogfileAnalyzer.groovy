package info.cosmicsand.logcruncher.contracts

public interface LogfileAnalyzer<LOGENTRY_TYPE extends Logentry> {

    LogfileStatistics analyze(LogVisitor logVisitor)
}
