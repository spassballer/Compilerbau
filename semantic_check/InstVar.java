package semantic_check;

import java.util.Map;
import java.util.Vector;

public class InstVar extends Expression{
    Expression exp;
    String name;

    @Override
    Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses) {
        return null;
    }
}
