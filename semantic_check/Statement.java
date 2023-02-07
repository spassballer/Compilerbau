package semantic_check;
import java.util.Map;

public abstract class Statement {
    Type type;
    abstract Type typeCheck(Map<String, Type> localVars, Clars clars);
}
