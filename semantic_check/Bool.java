package semantic_check;
import java.util.Map;
import java.util.Vector;

public class Bool extends Expression {
    boolean bool;

    public Bool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public Type typeCheck(Map<String, java.lang.reflect.Type> localvars, Vector<Class> clarses) {
        return Type.BOOLEAN;
    }
}
