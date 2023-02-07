import java.util.Map;

public class FieldDecl {
    String name;
    Type type;

    Type typeCheck(Map<String,Type> localVars, Clars clars){
        if(!(type.equals(Type.BOOLEAN)
                || type.equals(Type.CHAR)
                || type.equals(Type.INTEGER)
                || type.equals(Type.STRING))){
            // TODO Exception
        }
        for(FieldDecl field : clars.fields){
            if(field.name.equals(name)){
                // TODO Exception
            }
        }
        return type;
    }
}