

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Opcodes.ICONST_0;

public class Unary extends Expression{

    String operator;
    Expression expr;

    public Unary(String operator,Expression expr){
        this.operator = operator;
        this.expr = expr;
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        if(expr.typeCheck(localvars, clars).equals(Type.INT)){
            if(operator.contains("+")||operator.contains("-")){
                return Type.INT;
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
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        switch (operator){
            case "+":
                break;
            case "-":
                expr.codeGen(clars, methodDecl, mv);
                mv.visitInsn(INEG);
                break;
            case "++":
                if(expr instanceof LocalOrFieldVar){
                    LocalOrFieldVar var = (LocalOrFieldVar) expr;
                    int index = methodDecl.getIndexOfLocalVarByName(var.name);
                    if(index == -1){
                        throw new Exception("Cant find LocalOrFieldVar with name " + var.name);
                    }
                    mv.visitIincInsn(index, 1);
                }
                break;
            case "--":
                if(expr instanceof LocalOrFieldVar){
                    LocalOrFieldVar var = (LocalOrFieldVar) expr;
                    int index = methodDecl.getIndexOfLocalVarByName(var.name);
                    if(index == -1){
                        throw new Exception("Cant find LocalOrFieldVar with name " + var.name);
                    }
                    mv.visitIincInsn(index, -1);
                }
                break;
            case "!":
                Label notEqual = new Label();
                Label finish = new Label();

                expr.codeGen(clars, methodDecl, mv);
                mv.visitJumpInsn(IFNE, notEqual);
                mv.visitInsn(ICONST_1);
                mv.visitJumpInsn(GOTO, finish);
                mv.visitLabel(notEqual);
                mv.visitInsn(ICONST_0);
                mv.visitLabel(finish);
                break;
        }
    }

}