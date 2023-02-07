package semantic_check;

import java.util.Map;

public class Gstring extends Expression{
    String str;

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.STRING;
    }
    
}