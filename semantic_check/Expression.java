package semantic_check;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Vector;

public abstract class Expression {
    Type type;

    abstract Type typeCheck(Map<String,Type> localvars, Vector<Class> clarses);
}
