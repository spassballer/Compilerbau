package semantic_check;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Assign extends StmtExpr implements Opcodes {

    String name;
    Expression expression;
    LocalOrFieldVar localOrFieldVar;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        boolean fieldVar = false;
        Type varType = null; 
        for(FieldDecl field : clars.fields){
            if(field.name.equals(name)){
                fieldVar = true;
                varType = field.type;
                localOrFieldVar = new LocalOrFieldVar(field.name);
            }
        }
        if(localVars.containsKey(name) || fieldVar){
            if(varType==null) {
                varType = localVars.get(name);
                localOrFieldVar = new LocalOrFieldVar(name);
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

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        int index = methodDecl.getIndexOfLocalVar(localOrFieldVar);

        if (index == -1)
            mv.visitVarInsn(ALOAD, 0);
        expression.codeGen(clars, methodDecl, mv);
        if (index != -1)
            if (expression.type.equals(Type.STRING))
                mv.visitVarInsn(ASTORE, index);
            else
                mv.visitVarInsn(ISTORE, index);
        else
            mv.visitFieldInsn(PUTFIELD, clars.className, name, expression.type.getASMDescriptor());
    }
}