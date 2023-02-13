

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class StmtExprExpr extends Expression{

    StmtExpr stmtExpr;

    public StmtExprExpr(StmtExpr stmtExpr) {
        this.stmtExpr = stmtExpr;
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return stmtExpr.typeCheck(localvars, clars);
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        stmtExpr.codeGen(clars, methodDecl, mv);
    }

}