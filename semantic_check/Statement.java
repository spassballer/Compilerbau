package semantic_check;

import java.util.Map;
import java.util.Vector;

public abstract class Statement {
    Statement statment;
    abstract Type typeCheck(Map<String, Type> localVars, Vector<Class>
            classes);
}

