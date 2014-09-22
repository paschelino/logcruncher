package info.cosmicsand.logcruncher.ncsa.visitors

import info.cosmicsand.logcruncher.contracts.LogVisitor
import info.cosmicsand.logcruncher.ncsa.NCSAExtendedLogentry
import info.cosmicsand.logcruncher.ncsa.contracts.NCSALogStatistics
import info.cosmicsand.logcruncher.ncsa.model.RequestType

class NCSARequestTotalsVisitor implements LogVisitor<NCSAExtendedLogentry>, NCSALogStatistics {
    private long vistiedLogentriesCount
    final Map<RequestType, Long> requestCounts

    NCSARequestTotalsVisitor() {
        requestCounts = [:]
    }

    @Override
    void visit(NCSAExtendedLogentry logentry) {
        if (!logentry) {
            return
        }
        vistiedLogentriesCount++
        countRequest(logentry)
    }

    private void countRequest(NCSAExtendedLogentry logentry) {
        if (requestCounts[logentry.request.type])
            requestCounts[logentry.request.type]++
        else
            requestCounts[logentry.request.type] = 1L
    }

    @Override
    Long getVisitedLogentriesCount() {
        return vistiedLogentriesCount
    }

    @Override
    Long getRequestCount(RequestType requestType) {
        return requestCounts[requestType] ?: 0L
    }
}
