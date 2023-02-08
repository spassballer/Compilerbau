package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;
import java.util.Vector;

public abstract class Expression {
    Type type;

    abstract Type typeCheck(Map<String,Type> localvars, Vector<Class> clarses);

    abstract void codeGen(MethodVisitor mv);
}
