package semantic_check;

import java.util.Map;
import java.util.Vector;

public class JNull extends Expression{
    @Override
    Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses) {
        return null;
    }
}
