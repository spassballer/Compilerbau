package semantic_check;

import java.util.Map;

class Parameter {
    public Type type;
    public String name;

    public Parameter(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type typeCheck(Map<String, Type> localVars, Clars clars){
        if (!(type.equals(Type.BOOLEAN)
                || type.equals(Type.CHAR)
                || type.equals(Type.INTEGER)
                || type.equals(Type.STRING))){
            //TODO throw exception

        }
        return type;
    }
}