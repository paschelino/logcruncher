package info.cosmicsand.logcruncher.contracts

public interface LogStatistics<LOGENTRY_TYPE extends Logentry> {
    Long getVisitedLogentriesCount()
    String[] getColumnNames()
    List<String[]> getValueLines()
}
