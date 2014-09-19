package info.cosmicsand.logcruncher.contracts

public interface LogfileAnalyzer<LOGENTRY_TYPE extends Logentry> {

    LogStatistics analyze(LogVisitor logVisitor)
}
