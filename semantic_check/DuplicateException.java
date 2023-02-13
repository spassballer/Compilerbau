package semantic_check;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String message) {
        super(message);
    }
}
