

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;


public class This extends Expression implements Opcodes {
    
    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return clars.name;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        mv.visitVarInsn(ALOAD, 0);
    }

}