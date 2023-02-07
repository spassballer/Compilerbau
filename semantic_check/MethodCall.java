package semantic_check;

import java.util.Map;

public class MethodCall extends StmtExpr{

    Expression expression;
    String name;
    Expression[] expressions;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        MethodDecl myMethodDecl = null;
        for(MethodDecl method : clars.methods){
            if(method.name.equals(name)){
                myMethodDecl = method;
            }
        }
        if(myMethodDecl == null){
            //TODO Exception Method doesnt exist
        }
        if(expressions.length!=myMethodDecl.parameters.length){
            //TODO Exception Parameter error
        }
        for(int i = 0; i<expressions.length; i++){
            if(!expressions[i].type.equals(myMethodDecl.parameters[i].type)){
                //TODO Exception type missmatch
            }
        }
        return myMethodDecl.returnType;
    }
    
}
