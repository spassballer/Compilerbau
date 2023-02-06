package semantic_check;

import org.objectweb.asm.ClassWriter;

import java.util.Map;
import java.util.Vector;

public class Return extends Statement {
    Expression expression;
    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Class> clarses) {
        return null;
    }

    @Override
    void codeGen(ClassWriter cw) {

    }
}
