package semantic_check;

import java.util.Map;
import java.util.Vector;

public class Char extends Expression{
    char schar;

    @Override
    Type typeCheck(Map<String, java.lang.reflect.Type> localvars, Vector<Class> clarses) {
        return Type.CHAR;
    }
}
