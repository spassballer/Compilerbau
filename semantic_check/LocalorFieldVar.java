package semantic_check;

import java.util.Map;

public class LocalOrFieldVar extends Expression {

    String name;

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        if(localvars.containsKey(name)){
            return localvars.get(name);
        }
        for(FieldDecl fieldVar : clars.fields){
            if(fieldVar.name == name){
                return fieldVar.type;
            }
        }
        // TODO Exception not defined
        return null;
    }
    

}