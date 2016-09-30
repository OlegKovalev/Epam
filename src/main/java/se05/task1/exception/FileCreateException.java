package se05.task1.exception;

/**
 * Created by Олег on 29.09.2016.
 */
public class FileCreateException extends Exception {

    public FileCreateException() {
    }

    public FileCreateException(String message) {
        super(message);
    }

    public FileCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
