package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Unary extends Expression{

    String operator;
    Expression expr;

    public Unary(String operator,Expression expr){
        this.operator = operator;
        this.expr = expr;
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        if(expr.typeCheck(localvars, clars).equals(Type.INTEGER)){
            if(operator.contains("+")||operator.contains("-")){
                return Type.INTEGER;
            }
            //TODO Exception invalid operator for integer
        }
        if(expr.typeCheck(localvars, clars).equals(Type.BOOLEAN)){
            if(operator.contains("!")){
                return Type.BOOLEAN;
            }
            //TODO Exception invalid operator for boolean
        }
        //TODO Exception invalid blabla bla
        return null;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {

    }

}