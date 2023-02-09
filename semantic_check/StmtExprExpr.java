package semantic_check;

import java.util.Map;

public class StmtExprExpr extends Expression{

    StmtExpr stmtExpr;

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return stmtExpr.typeCheck(localvars, clars);
    }
    
}