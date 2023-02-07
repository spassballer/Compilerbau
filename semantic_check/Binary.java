package semantic_check;

import java.util.Map;

public class Binary extends Expression{
    String operator;
    Expression exp1;
    Expression exp2;

    @Override
    Type typeCheck(Map<String, Type> localvars,Clars clars) {
        if (exp1.typeCheck(localvars,clars).equals(exp2.typeCheck(localvars,clars))){
            if (!(exp1.typeCheck(localvars,clars).equals(Type.INTEGER) ||
                    exp1.typeCheck(localvars,clars).equals(Type.STRING))){
                return null;
            }
            if (operator.equals("+")){
                return exp1.typeCheck(localvars,clars);
            }
            if ("-%*".contains(operator)){
                if (exp1.typeCheck(localvars,clars).equals(Type.INTEGER)){
                    return Type.INTEGER;
                }
            }
            if (operator.equals("&&") || operator.equals("||")){
                if (exp1.typeCheck(localvars,clars).equals(Type.BOOLEAN)){
                    return Type.BOOLEAN;
                }
            }

        }
        return null; //TODO throw an error
    }

}