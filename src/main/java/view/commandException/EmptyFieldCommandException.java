package view.commandException;

public class EmptyFieldCommandException extends RuntimeException {
    public EmptyFieldCommandException(String message) {
        super(message);
    }
}
