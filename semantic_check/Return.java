package semantic_check;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Return extends Statement implements Opcodes {

    Expression expression;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        return expression.typeCheck(localVars, clars);
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {

        if (expression!= null) {
            expression.codeGen(clars, methodDecl, mv);
            if (expression instanceof JString)
                mv.visitInsn(ARETURN);
            else
                mv.visitInsn(IRETURN);
        }
        else
            mv.visitInsn(RETURN);
        mv.visitJumpInsn(GOTO, methodDecl.endLabel);
    }
}
