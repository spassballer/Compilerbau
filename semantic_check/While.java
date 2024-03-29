
import java.util.Map;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class While extends Statement{
    Expression condition;
    Statement stmt;

    public While(Expression condition, Statement stmt) {
        this.condition = condition;
        this.stmt = stmt;
    }

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if(condition.typeCheck(localVars, clars).equals(Type.BOOLEAN)){
            type = stmt.typeCheck(localVars, clars);
            return type;
        }
        throw new InvalidTypeException("Condition " + condition + " is not a boolean");
    }

    public void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        Label start = new Label();
        Label end = new Label();

        mv.visitLabel(start);

        condition.codeGen(clars, methodDecl, mv);
        mv.visitJumpInsn(Opcodes.IFEQ, end);

        stmt.codeGen(clars, methodDecl, mv);

        mv.visitJumpInsn(Opcodes.GOTO, start);
        mv.visitLabel(end);
    }
}
