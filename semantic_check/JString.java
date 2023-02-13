

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class JString extends Expression{
    String str;

    public JString(String str) {
        this.str = str;
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.STRING;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        mv.visitLdcInsn(str);
    }

}