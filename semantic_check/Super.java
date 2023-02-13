package semantic_check;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Super extends Expression implements Opcodes {

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.OBJECT;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        mv.visitVarInsn(ALOAD, 0);
    }

}