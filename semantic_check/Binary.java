

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Binary extends Expression {
    String operator;
    Expression exp1;
    Expression exp2;

    public Binary(String operator, Expression exp1, Expression exp2) {
        this.operator = operator;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        Type type1 = exp1.typeCheck(localvars,clars);
        Type type2 = exp2.typeCheck(localvars,clars);
        if (!type1.equals(type2)) {
            throw new InvalidTypeException("The type " + exp1.type + " and type " + exp2.type + " cant be combined");
        }
        if (type1.equals(Type.INT) || type2.equals(Type.STRING)) {
            if (operator.equals("+")){
                return type1;
            }
            if (type1.equals(Type.INT)){
                if ("-%*/".contains(operator)) {
                    return Type.INT;
                } else if (operator.equals("==")
                        || operator.equals("!=")
                        || operator.equals(">=")
                        || operator.equals(">")
                        || operator.equals("<=")
                        || operator.equals("<")) {
                    return Type.BOOLEAN;
                }
            }
            throw new InvalidTypeException("Invalid type " + exp1.type + " must be String or int");
        } else if (type1.equals(Type.CHAR)) {
            if (operator.equals("==") || operator.equals("!=")){
                return Type.BOOLEAN;
            }
        } else if (type1.equals(Type.BOOLEAN)) {
            if (operator.equals("||") || operator.equals("&&") || operator.equals("==") || operator.equals("!=")) {
                return Type.BOOLEAN;
            }
        }
        throw new InvalidTypeException("Invalid operator " + operator);
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        int ifOpcode = 0;

        if (operator.equals("&&")) {
            Label notEqualTrue = new Label();
            Label finish = new Label();

            //Load exp1, if false: jump to Label notEqualTrue
            exp1.codeGen(clars, methodDecl, mv);
            mv.visitJumpInsn(Opcodes.IFEQ, notEqualTrue);
            //Do the same for exp2
            exp2.codeGen(clars, methodDecl, mv);
            mv.visitJumpInsn(Opcodes.IFEQ, notEqualTrue);

            //Load true, then jump label finish
            // (this can only happen if exp1 and exp2 is true,
            // because else we would have jumped to Label notEqualTrue
            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitJumpInsn(Opcodes.GOTO, finish);

            //Visit label notEqualTrue, load false
            mv.visitLabel(notEqualTrue);
            mv.visitInsn(Opcodes.ICONST_0);

            //Visit label finish
            mv.visitLabel(finish);
        } else if (operator.equals("||")) {
            Label equalTrue = new Label();
            Label notEqualTrue = new Label();
            Label finish = new Label();

            //Load exp1, if true: jump to Label equalTrue
            exp1.codeGen(clars, methodDecl, mv);
            mv.visitJumpInsn(Opcodes.IFNE, equalTrue);

            //Load exp2, if false: jump to Label notEqualTrue
            exp2.codeGen(clars, methodDecl, mv);
            mv.visitJumpInsn(Opcodes.IFEQ, notEqualTrue);

            //visit Label equalTrue, load true, go to Label finish
            mv.visitLabel(equalTrue);
            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitJumpInsn(Opcodes.GOTO, finish);

            //visit Label notEqualTrue, load false
            mv.visitLabel(notEqualTrue);
            mv.visitInsn(Opcodes.ICONST_0);

            mv.visitLabel(finish);
        } else if (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*") || operator.equals("%")) {
            exp1.codeGen(clars, methodDecl, mv);
            exp2.codeGen(clars, methodDecl, mv);
            switch (operator) {
                case "+":
                    if (exp1 instanceof JString && exp2 instanceof JString) {
                        //Append strings
                        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/String", "concat", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false);
                    } else {
                        mv.visitInsn(Opcodes.IADD);
                    }
                    break;
                case "-":
                    mv.visitInsn(Opcodes.ISUB);
                    break;
                case "/":
                    mv.visitInsn(Opcodes.IDIV);
                    break;
                case "*":
                    mv.visitInsn(Opcodes.IMUL);
                    break;
                case "%":
                    mv.visitInsn(Opcodes.IREM);
            }
        } else {
            Label notEqual = new Label();
            Label finish = new Label();

            exp1.codeGen(clars, methodDecl, mv);
            exp2.codeGen(clars, methodDecl, mv);

            switch (operator) {
                case "==":
                    mv.visitJumpInsn(Opcodes.IF_ICMPNE, notEqual);
                    break;
                case "!=":
                    mv.visitJumpInsn(Opcodes.IF_ICMPEQ, notEqual);
                    break;
                case ">":
                    mv.visitJumpInsn(Opcodes.IF_ICMPLE, notEqual);
                    break;
                case ">=":
                    mv.visitJumpInsn(Opcodes.IF_ICMPLT, notEqual);
                    break;
                case "<":
                    mv.visitJumpInsn(Opcodes.IF_ICMPGE, notEqual);
                    break;
                case "<=":
                    mv.visitJumpInsn(Opcodes.IF_ICMPGT, notEqual);
                    break;
            }

            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitJumpInsn(Opcodes.GOTO, finish);
            mv.visitLabel(notEqual);
            mv.visitInsn(Opcodes.ICONST_0);
            mv.visitLabel(finish);
        }
    }
}
