package semantic_check;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Vector;

public class Bool extends Expression {
    boolean bool;

    @Override
    public Typ typeCheck(Map<String, Type> localvars, Vector<Class> clarses){
        return Typ.BOOLEAN;
    }
}
