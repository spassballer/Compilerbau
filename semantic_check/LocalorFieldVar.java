package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Vector;

public class LocalorFieldVar extends Expression{
    String local;

    @Override
    semantic_check.Type typeCheck(Map<String, semantic_check.Type> localvars, Vector<Class> clarses) {
        return null;
    }

    @Override
    void codeGen(MethodVisitor mv) {

    }
}
