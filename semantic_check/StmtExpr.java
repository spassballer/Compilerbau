package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public abstract class StmtExpr{
    Statement statement;
    Expression expression;

    abstract Type typeCheck(Map<String, Type> localVars, Clars clars);

    abstract void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception;

}