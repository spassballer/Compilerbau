package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Char extends Expression{
    char schar;

    @Override
    Type typeCheck(Map<String, Type> localvars,Clars clars) {
        return Type.CHAR;
    }

    @Override
    void codeGen(MethodVisitor mv) {

    }
}
