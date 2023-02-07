

import java.util.Map;

public class MethodDecl {
    public String name;
    public Type returnType;
    public Parameter[] parameters;
    public Block block;

    public MethodDecl(String name, Type returnType, Parameter[] parameters, Block block) {
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.block = block;
    }

    public Type typeCheck(Map<String, Type> localVars, Clars clars) {
        for (MethodDecl method : clars.methods) {
            if (method.name.equals(name)) {
                // TODO Exception
            }
        }
        if (!(returnType.equals(Type.BOOLEAN)
                || returnType.equals(Type.CHAR)
                || returnType.equals(Type.INTEGER)
                || returnType.equals(Type.STRING)
                || returnType.equals(Type.VOID))) {
            // TODO Exception
        }
        for (Parameter parameter: parameters){
            parameter.typeCheck(localVars,clars);
            localVars.put(parameter.name,parameter.type);
        }
        Type blockType = block.typeCheck(localVars,clars);
        if (!blockType.equals(returnType)){
            //TODO Exception
        }
        return returnType;
    }
}