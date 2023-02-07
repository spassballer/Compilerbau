import java.util.Map;

public class LocalVarDecl extends Statement{

    Type varType;
    String varName;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if(localVars.containsKey(varName)){
            //TODO Exception Variable already exists
        }
        if (!(varType.equals(Type.BOOLEAN)
                || varType.equals(Type.CHAR)
                || varType.equals(Type.INTEGER)
                || varType.equals(Type.STRING))) {
            //TODO Exception invalid Type
        }
        localVars.put(varName, varType);
        return varType;
    }
}