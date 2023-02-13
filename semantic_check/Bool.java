
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import java.util.Map;

public class Bool extends Expression {
    boolean bool;

    public Bool(boolean bool) {
        this.bool = bool;
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.BOOLEAN;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv){
        mv.visitInsn(bool ? Opcodes.ICONST_1 : Opcodes.ICONST_0);
    }
}
