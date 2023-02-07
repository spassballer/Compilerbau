package semantic_check;

import java.util.Map;
import java.util.Vector;

public class If {
    Expression cond;
    Statement ifStmt;
    Statement elseStmt;

    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if (cond.typeCheck(localVars, clars).equals(new Type("boolean"))
                && ifStmt.typeCheck(localVars, clars)
                .equals(elseStmt.typeCheck(localVars, clars))) {
            var typ = ifStmt.typeCheck(localVars, clars);
            return typ;
        } else {
            return null;
        }
    }
}