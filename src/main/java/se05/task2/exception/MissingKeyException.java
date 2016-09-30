package se05.task2.exception;

public class MissingKeyException extends Exception {

    public MissingKeyException() {
    }

    public MissingKeyException(String message) {
        super(message);
    }

    public MissingKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingKeyException(Throwable cause) {
        super(cause);
    }

    public MissingKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
