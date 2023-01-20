package semantic_check;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Vector;

public class Binary extends Expression{
    String name;
    Expression exp1;
    Expression exp2;

    @Override
    public Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses){
        return type;
    }


}
