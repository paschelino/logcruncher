package info.cosmicsand.logcruncher

class LogIteratorMock<LOGENTRY_TYPE> implements LogIterator<LOGENTRY_TYPE> {
    List<LOGENTRY_TYPE> entries = []
    int entryIndex = 0;

    def appendEntries(LOGENTRY_TYPE... entries) {
        this.entries += entries
    }


    @Override
    boolean hasNext() {
        return entryIndex < entries.size()
    }

    @Override
    LOGENTRY_TYPE next() {
        if (hasNext())
            return entries[entryIndex++]
        else
            throw new NoSuchElementException("End of iteration has been overrun.")
    }

}
