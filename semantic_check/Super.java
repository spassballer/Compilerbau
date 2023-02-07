package semantic_check;

import java.util.Map;

public class Super extends Expression{

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.OBJECT;
    }
    
}