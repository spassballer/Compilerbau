package semantic_check;
import java.util.Map;

public class New extends StmtExpr {

    Type type;
    Expression[] expressions;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if (type.equals(Type.BOOLEAN)
                || type.equals(Type.CHAR)
                || type.equals(Type.INT)
                || type.equals(Type.VOID)
                || type.equals(Type.NULL)) {
            if(type.equals(clars.name)){
                if(expressions.length == 0){
                    return type;
                }
                //TODO Exception No parameters allowed in empty Constructor
            }
            //TODO Exception not expected Classtype
        }
        //TODO Exception invalid type
        return null;
    }

}