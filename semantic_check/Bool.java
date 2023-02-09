package semantic_check;
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

    void codeGen(MethodVisitor mv){
        mv.visitInsn(bool ? Opcodes.ICONST_1 : Opcodes.ICONST_0);
    }
}