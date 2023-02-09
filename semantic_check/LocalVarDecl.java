package semantic_check;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

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

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        methodDecl.localVar.add(new LocalOrFieldVar(varName));
    }
}