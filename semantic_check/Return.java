
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Return extends Statement implements Opcodes {

    Expression expression;

    public Return(Expression expression) {
        this.expression = expression;
    }

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        type = expression.typeCheck(localVars, clars);
        return type;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {

        if (expression!= null) {
            expression.codeGen(clars, methodDecl, mv);
            if (expression.type.equals(Type.STRING))
                mv.visitInsn(ARETURN);
            else
                mv.visitInsn(IRETURN);
        }
        else
            mv.visitInsn(RETURN);
        //mv.visitJumpInsn(GOTO, methodDecl.endLabel);
    }
}
