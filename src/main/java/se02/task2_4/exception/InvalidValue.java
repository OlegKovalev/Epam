package se02.task2_4.exception;

public class InvalidValue extends Exception {

    private static final String DEFAULT_MESSAGE = "You value is not correct!";

    public InvalidValue(String message) {
        super(message);
    }

    public InvalidValue() {
        super(DEFAULT_MESSAGE);
    }
}
