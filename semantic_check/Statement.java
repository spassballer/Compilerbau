package semantic_check;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public abstract class Statement {
    Type type;
    abstract Type typeCheck(Map<String, Type> localVars, Clars clars);
    abstract void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv);
}
