package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class JNull extends Expression{

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.NULL;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {

    }
}
