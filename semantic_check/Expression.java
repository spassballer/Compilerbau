

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public abstract class Expression {
    Type type;

    abstract Type typeCheck(Map<String,Type> localvars,Clars clars);

    abstract void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception;
}
