package semantic_check;

import java.util.Map;

public abstract class Expression {
    Type type;

    public Expression(){
        
    }

    abstract Type typeCheck(Map<String,Type> localvars,Clars clars);

}