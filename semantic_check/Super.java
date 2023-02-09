package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Super extends Expression{

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.OBJECT;
    }

    @Override
    void codeGen(MethodVisitor mv) {

    }

}