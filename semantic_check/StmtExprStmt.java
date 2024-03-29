

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class StmtExprStmt extends Statement {

    StmtExpr stmtExpr;

    public StmtExprStmt(StmtExpr stmtExpr) {
        this.stmtExpr = stmtExpr;
    }

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        stmtExpr.typeCheck(localVars, clars);
        type = Type.VOID;
        return type;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        stmtExpr.codeGen(clars, methodDecl, mv);
    }

}