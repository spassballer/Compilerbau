package semantic_check;

import java.util.Map;

public class Assign extends StmtExpr {

    String name;
    Expression expression;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        boolean fieldVar = false;
        Type varType = null; 
        for(FieldDecl field : clars.fields){
            if(field.name.equals(name)){
                fieldVar = true;
                varType = field.type;
            }
        }
        if(localVars.containsKey(name) || fieldVar){
            if(varType==null) {
                varType = localVars.get(name);
            }
            Type expressionType = expression.typeCheck(localVars, clars);
            if(varType.equals(expressionType) 
                    // primitive types must not be null
                || (!(varType.equals(Type.BOOLEAN) || varType.equals(Type.CHAR) || varType.equals(Type.INTEGER)) 
                    && expressionType.equals(Type.NULL))){
                return varType;
            }
            //TODO Exception type does not match
        }
        //TODO Exception does not exist
        return null;
    }
    
}