package semantic_check;

public class InvalidTypeException extends RuntimeException{
    public InvalidTypeException(String message) {
        super(message);
    }
}
