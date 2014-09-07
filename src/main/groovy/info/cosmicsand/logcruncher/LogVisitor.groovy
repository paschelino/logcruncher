package info.cosmicsand.logcruncher

public interface LogVisitor<LOGENTRY_TYPE extends Logentry> {
    void visit(LOGENTRY_TYPE logentry)
    LogfileStatistics getStatistics()
}
