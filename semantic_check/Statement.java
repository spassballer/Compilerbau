package semantic_check;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;
import java.util.Vector;

public abstract class Statement {
    Statement statement;
    abstract Type typeCheck(Map<String, Type> localVars, Vector<Class>
            classes);

    abstract void codeGen(MethodVisitor mv);
}

