package info.cosmicsand.logcruncher.ncsa

import info.cosmicsand.logcruncher.contracts.LogIterator
import info.cosmicsand.logcruncher.contracts.LogVisitor
import info.cosmicsand.logcruncher.contracts.LogfileAnalyzer
import info.cosmicsand.logcruncher.contracts.LogStatistics
import info.cosmicsand.logcruncher.ncsa.visitors.NCSARequestTotalsVisitor

public class NCSALogfileAnalyzer implements LogfileAnalyzer<NCSARequestTotalsVisitor> {
    final LogIterator<NCSAExtendedLogentry> lowLevelReader

    public NCSALogfileAnalyzer(LogIterator lowLevelReader) {
        this.lowLevelReader = lowLevelReader
    }

    @Override
    public LogStatistics analyze(NCSARequestTotalsVisitor logVisitor) {
        while (lowLevelReader.hasNext()) {
            logVisitor.visit(lowLevelReader.next())
        }
        return logVisitor.getStatistics()
    }
}
