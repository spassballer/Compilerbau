package semantic_check;

import java.util.Map;

public class Sinteger extends Expression{
    Integer sinteger;

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.INTEGER;
    }
}