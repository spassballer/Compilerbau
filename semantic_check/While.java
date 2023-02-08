package semantic_check;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class While{

    Expression cond;
    Statement whileStmt;

    public void codeGen(MethodVisitor mv){
        Label start = new Label();
        Label end = new Label();

        mv.visitLabel(start);

        cond.codeGen(mv);
        mv.visitJumpInsn(Opcodes.IFEQ, end);

        whileStmt.codeGen(mv);

        mv.visitJumpInsn(Opcodes.GOTO, start);
        mv.visitLabel(end);
    }
}
