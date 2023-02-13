
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class LocalVarDecl extends Statement {

    Type varType;
    String varName;

    public LocalVarDecl(Type varType, String varName) {
        this.varType = varType;
        this.varName = varName;
    }

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if (localVars.containsKey(varName)) {
            throw new DuplicateException("Variable " + varName + " already exists.");
        }
        if (!(varType.equals(Type.BOOLEAN)
                || varType.equals(Type.CHAR)
                || varType.equals(Type.INT)
                || varType.equals(Type.STRING)
                || varType.equals(Type.CLASSTYPE))) {
            throw new InvalidTypeException("Invalid type: "+varType+" at variable declaration: " + varName);
        }
        localVars.put(varName, varType);
        type = Type.VOID;
        return type;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        methodDecl.localVar.add(new LocalOrFieldVar(varName));
    }
}