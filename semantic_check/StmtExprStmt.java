package semantic_check;

import java.util.Map;

public class StmtExprStmt extends Statement {

    StmtExpr stmtExpr;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        stmtExpr.typeCheck(localVars, clars);
        return Type.VOID;
    }

}