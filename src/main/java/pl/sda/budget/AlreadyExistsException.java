package pl.sda.budget;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String message) {
        super(message);
    }
}
