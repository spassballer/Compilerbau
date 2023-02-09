package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class This extends Expression{
    
    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return clars.name;
    }

    @Override
    void codeGen(MethodVisitor mv) {

    }

}