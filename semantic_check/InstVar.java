

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

import static org.objectweb.asm.Opcodes.GETFIELD;

public class InstVar extends Expression {

    Expression expression;
    String name;

    public InstVar(Expression expression, String name) {
        this.expression = expression;
        this.name = name;
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        Type exprType = expression.typeCheck(localvars, clars);
        if (exprType.equals(Type.BOOLEAN)
                || exprType.equals(Type.CHAR)
                || exprType.equals(Type.INT)
                || exprType.equals(Type.VOID)
                || exprType.equals(Type.NULL)) {
            if (exprType.equals(clars.name)) {
                for (FieldDecl field : clars.fields) {
                    if (field.name.equals(name)) {
                        return field.type;
                    }
                }
                //TODO Exception: Class does not contain variable name
            }
            //TODO Exception: Expression is not equal to expected class type
        }
        //TODO Exception: Expression must be a valid Class type
        return null;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        expression.codeGen(clars, methodDecl, mv);
        mv.visitFieldInsn(GETFIELD, clars.className, name, type.getASMDescriptor());
    }
}
