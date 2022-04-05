package View.Commands;

public class WrongFieldComandException extends RuntimeException {
    public WrongFieldComandException(String message) {
        super(message);
    }
}