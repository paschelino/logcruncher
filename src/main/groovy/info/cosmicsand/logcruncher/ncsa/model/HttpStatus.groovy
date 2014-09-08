package info.cosmicsand.logcruncher.ncsa.model

public enum HttpStatus {
    EMPTY_STATUS(-1I)

    HttpStatus(int value) {
        this.value = value
    }
    final int value
}