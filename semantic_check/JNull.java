package semantic_check;

import java.util.Map;

public class Jnull extends Expression{

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.NULL;
    }
    
}