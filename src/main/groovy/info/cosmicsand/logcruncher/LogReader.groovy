package info.cosmicsand.logcruncher

public interface LogReader<LOGENTRY_TYPE extends Logentry> {
    
    LOGENTRY_TYPE readNextEntry()

}