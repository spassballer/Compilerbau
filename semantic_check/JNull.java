

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

import static org.objectweb.asm.Opcodes.ACONST_NULL;

import static org.objectweb.asm.Opcodes.ACONST_NULL;

public class JNull extends Expression{

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        type = Type.NULL;
        return Type.NULL;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        mv.visitInsn(ACONST_NULL);
    }
}
