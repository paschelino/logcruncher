package info.cosmicsand.logcruncher.ncsa.contracts

import info.cosmicsand.logcruncher.contracts.LogStatistics
import info.cosmicsand.logcruncher.ncsa.NCSAExtendedLogentry
import info.cosmicsand.logcruncher.ncsa.model.RequestType

public interface NCSALogStatistics extends LogStatistics<NCSAExtendedLogentry> {
    Long getRequestCount(RequestType requestType)
}