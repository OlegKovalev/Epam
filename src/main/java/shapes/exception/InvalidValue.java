package shapes.exception;

public class InvalidValue extends Exception {

    private static final String DEFAULT_MESSAGE = "You value is not correct!";

    public InvalidValue() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidValue(String message) {
        super(message);
    }
}
