package semantic_check;

public class UnexpectedType extends RuntimeException{
    public UnexpectedType(String message) {
        super(message);
    }
}
