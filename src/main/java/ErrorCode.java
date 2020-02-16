public enum ErrorCode {
    PARTS_COUNT_MUST_BE_TWO_AT_LEAST("Invalid parts count");
    private String errorString;

    private ErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
