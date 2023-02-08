package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;
import java.util.Vector;

public class Char extends Expression{
    char schar;

    @Override
    Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses) {
        return Type.CHAR;
    }

    @Override
    void codeGen(MethodVisitor mv) {

    }
}
