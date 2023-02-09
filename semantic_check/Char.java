package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

import static org.objectweb.asm.Opcodes.BIPUSH;
import static org.objectweb.asm.Opcodes.ISTORE;

public class Char extends Expression{
    char schar;

    @Override
    Type typeCheck(Map<String, Type> localvars,Clars clars) {
        return Type.CHAR;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        mv.visitLdcInsn(schar);
    }
}
