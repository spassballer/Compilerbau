import java.util.Map;

public class While extends Statement{
    Statement stmt;
    Expression exp;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if(stmt.typeCheck(localVars, clars).equals(Type.BOOLEAN)){
            return stmt.typeCheck(localVars, clars);
        }
        return null;
    }
}