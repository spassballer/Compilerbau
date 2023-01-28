package semantic_check;



import java.util.Map;
import java.util.Vector;

public class If {
    Expression cond;
    Statement ifStmt;
    Statement elseStmt;

    Type typeCheck(Map<String, Type> localVars, Vector<Class> classes) {
        if (cond.typeCheck(localVars, classes).equals(new Type("boolean"))
                && ifStmt.typeCheck(localVars, classes)
                .equals(elseStmt.typeCheck(localVars, classes))) {
            var typ = ifStmt.typeCheck(localVars, classes);
            return typ;
        } else {
            return null;
        }
    }
}