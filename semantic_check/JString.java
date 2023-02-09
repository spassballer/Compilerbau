package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class JString extends Expression{
    String str;

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.STRING;
    }

    @Override
    void codeGen(MethodVisitor mv) {

    }

}