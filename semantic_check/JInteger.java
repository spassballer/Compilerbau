package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class JInteger extends Expression{
    int jInteger;

    public JInteger(String num) {
        this.jInteger = Integer.parseInt(num);
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.INT;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        mv.visitLdcInsn(jInteger);
    }
}