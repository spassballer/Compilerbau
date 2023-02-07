package semantic_check;

import java.util.Map;

public class Char extends Expression{
    char schar;

    @Override
    Type typeCheck(Map<String, Type> localvars,Clars clars) {
        return Type.CHAR;
    }
}