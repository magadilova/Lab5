package View.Commands;

public class WrongFieldComandException extends RuntimeException {
    public WrongFieldComandException(String message) {
        super("There is no element with the given field value\n");
    }
}