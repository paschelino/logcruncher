package info.cosmicsand.logcruncher.contracts

public interface LogfileAnalyzer<LOG_VISITOR extends LogVisitor> {

     LogStatistics analyze(LOG_VISITOR logVisitor)
}
