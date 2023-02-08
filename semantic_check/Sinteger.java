package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;
import java.util.Vector;

public class Sinteger extends Expression{
    Integer sinteger;

    @Override
    Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses) {
        return Type.INTEGER;
    }

    @Override
    void codeGen(MethodVisitor mv) {

    }
}
