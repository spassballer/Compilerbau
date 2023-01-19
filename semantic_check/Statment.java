package semantic_check;

import java.util.Map;
import java.util.Vector;

public abstract class Statment {
    Type typ;
    abstract Type typeCheck(Map<String, Type> localVars, Vector<Class>
            classes);

}
