package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Sinteger extends Expression{
    Integer sinteger;

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.INT;
    }

    @Override
    void codeGen(MethodVisitor mv) {

    }
}
