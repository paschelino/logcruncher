package info.cosmicsand.logcruncher.contracts

public interface LogVisitor<LOGENTRY_TYPE extends Logentry> extends LogStatistics<LOGENTRY_TYPE> {
    void visit(LOGENTRY_TYPE logentry)
}
