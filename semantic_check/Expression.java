package semantic_check;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Vector;

public abstract class Expression {
    enum Typ{
        BOOLEAN,
        INTEGER,
        CHAR,
    }
    Typ type;

    public Typ typeCheck(Map<String,Type> localvars, Vector<Class> clarses){
        return type;
    }
}
