public class SeparatorException extends Exception {
    public SeparatorException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getErrorString(), cause);
    }

    public SeparatorException(ErrorCode errorCode) {
        super(errorCode.getErrorString());
    }

    public SeparatorException(ErrorCode errorCode, String param) {
        super(String.format(errorCode.getErrorString(), param));
    }
}
