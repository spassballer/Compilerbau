package semantic_check;

import java.util.Map;
import java.util.Vector;

public class Binary extends Expression{
    String operator;
    Expression exp1;
    Expression exp2;

    @Override
    Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses) {
        if (exp1.typeCheck(localvars,clarses).equals(exp2.typeCheck(localvars,clarses))){
            if (!(exp1.typeCheck(localvars,clarses).equals(Type.INTEGER) ||
                    exp1.typeCheck(localvars,clarses).equals(Type.STRING))){
                return null;
            }
            if (operator.equals("+")){
                return exp1.typeCheck(localvars,clarses);
            }
            if ("-%*".contains(operator)){
                if (exp1.typeCheck(localvars,clarses).equals(Type.INTEGER)){
                    return exp1.typeCheck(localvars,clarses);
                }
            }

        }
        return null;
    }
}
