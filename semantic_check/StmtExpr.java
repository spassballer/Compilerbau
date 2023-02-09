package semantic_check;

import java.util.Map;

public abstract class StmtExpr{
    Statement statement;
    Expression expression;

    abstract Type typeCheck(Map<String, Type> localVars, Clars clars);

}