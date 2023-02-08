package semantic_check;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;
import java.util.Vector;

public class Binary extends Expression {
    String operator;
    Expression exp1;
    Expression exp2;

    @Override
    Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses) {
        if (exp1.typeCheck(localvars, clarses).equals(exp2.typeCheck(localvars, clarses))) {
            if (!(exp1.typeCheck(localvars, clarses).equals(Type.INTEGER) ||
                    exp1.typeCheck(localvars, clarses).equals(Type.STRING))) {
                return null;
            }
            if (operator.equals("+")) {
                return exp1.typeCheck(localvars, clarses);
            }
            if ("-%*".contains(operator)) {
                if (exp1.typeCheck(localvars, clarses).equals(Type.INTEGER)) {
                    return exp1.typeCheck(localvars, clarses);
                }
            }
            if (operator.equals("&&") || operator.equals("||")) {
                if (exp1.typeCheck(localvars, clarses).equals(Type.BOOLEAN)) {
                    return exp1.typeCheck(localvars, clarses);
                }
            }

        }
        return null; //TODO throw an error
    }

    void codeGen(MethodVisitor mv) {
        int ifOpcode = 0;

        switch (operator) {
            case "&&":
                ifOpcode = Opcodes.IF_ICMPEQ;
                break;
            case "||":
                ifOpcode = Opcodes.IF_ICMPNE;
                break;
        }

        if(exp1 instanceof Binary)
            codeGen(mv);




    }
}
