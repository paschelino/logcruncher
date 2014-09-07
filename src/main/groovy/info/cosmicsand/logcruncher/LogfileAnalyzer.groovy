package info.cosmicsand.logcruncher

import java.io.BufferedReader

public interface LogfileAnalyzer<LOGENTRY_TYPE extends Logentry> {

    LogfileStatistics analyze(LogVisitor logVisitor)
}
