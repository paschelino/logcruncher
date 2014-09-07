package info.cosmicsand.logcruncher

public class NCSALogfileAnalyzer implements LogfileAnalyzer<NCSALogentry> {
    final LogIterator<NCSALogentry> lowLevelReader

    public NCSALogfileAnalyzer(LogIterator lowLevelReader) {
        this.lowLevelReader = lowLevelReader
    }

    @Override
    public LogfileStatistics analyze(LogVisitor logVisitor) {
        if (lowLevelReader.hasNext()) {
            logVisitor.visit(lowLevelReader.next())
        }
        return logVisitor.getStatistics()
    }
}
