package semantic_check;
import java.util.Map;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class While extends Statement{
    Statement stmt;
    Expression exp;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if(exp.typeCheck(localVars, clars).equals(Type.BOOLEAN)){
            return exp.typeCheck(localVars, clars);
        }
        return null;
    }

    public void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        Label start = new Label();
        Label end = new Label();

        mv.visitLabel(start);

        exp.codeGen(clars, methodDecl, mv);
        mv.visitJumpInsn(Opcodes.IFEQ, end);

        stmt.codeGen(clars, methodDecl, mv);

        mv.visitJumpInsn(Opcodes.GOTO, start);
        mv.visitLabel(end);
    }
}
