package info.cosmicsand.logcruncher

public class NCSALogfileAnalyzer implements LogfileAnalyzer<NCSALogentry> {
    public NCSALogfileAnalyzer(LogReader lowLevelReader) {
    }

    @Override
    public LogfileStatistics analyze(LogVisitor logVisitor) {
        return logVisitor.getStatistics()
    }
}
