package info.cosmicsand.logcruncher

class LogReaderMock implements LogReader {
    String[] entries
    int entryIndex;

    public LogReaderMock(Logentry... entries) {
        this.entries = entries
        this.entryIndex = 0
    }

    @Override
    Logentry readNextEntry() {
        return entryIndex < entries.length ? entries[entryIndex++] : null
    }
}
