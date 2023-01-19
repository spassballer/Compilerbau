package semantic_check;

import java.beans.Statement;
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
            typ = ifStmt.typeCheck(localVars, classes);
            return typ; }
        else {
            //
        }
}