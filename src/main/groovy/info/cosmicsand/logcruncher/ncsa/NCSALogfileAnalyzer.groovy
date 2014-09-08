package info.cosmicsand.logcruncher.ncsa

import info.cosmicsand.logcruncher.contracts.LogIterator
import info.cosmicsand.logcruncher.contracts.LogVisitor
import info.cosmicsand.logcruncher.contracts.LogfileAnalyzer
import info.cosmicsand.logcruncher.contracts.LogfileStatistics

public class NCSALogfileAnalyzer implements LogfileAnalyzer<NCSAExtendedLogentry> {
    final LogIterator<NCSAExtendedLogentry> lowLevelReader

    public NCSALogfileAnalyzer(LogIterator lowLevelReader) {
        this.lowLevelReader = lowLevelReader
    }

    @Override
    public LogfileStatistics analyze(LogVisitor logVisitor) {
        while (lowLevelReader.hasNext()) {
            logVisitor.visit(lowLevelReader.next())
        }
        return logVisitor.getStatistics()
    }
}
