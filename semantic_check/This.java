package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

import static org.objectweb.asm.Opcodes.ALOAD;

public class This extends Expression{
    
    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return clars.name;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        mv.visitVarInsn(ALOAD, 0);
    }

}