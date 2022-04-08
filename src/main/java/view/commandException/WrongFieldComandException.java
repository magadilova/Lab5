package view.commandException;

public class WrongFieldComandException extends RuntimeException {
    public WrongFieldComandException(String message) {
        super(message);
    }
}