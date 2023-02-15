

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Assign extends StmtExpr implements Opcodes {

    String name;
    Expression expression;
    Type type;

    public Assign(final String name, final Expression expression) {
        this.name = name;
        this.expression = expression;
    }

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
            if(varType==null) { // -> localvar
                varType = localVars.get(name);
            }
            Type expressionType = expression.typeCheck(localVars, clars);
            if(varType.equals(expressionType) 
                    // primitive types must not be null
                || (!(varType.equals(Type.BOOLEAN) || varType.equals(Type.CHAR) || varType.equals(Type.INT))
                    && expressionType.equals(Type.NULL))){
                type = varType;
                return type;
            }
            throw new InvalidTypeException("Type " + expressionType + " can't be assigned to " + varType +" type");
        }
        throw new NotDeclaredException("Variable " + name + " is not declared");
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        int index = methodDecl.getIndexOfLocalVarByName(name);

        if (index == -1)
            mv.visitVarInsn(ALOAD, 0);
        expression.codeGen(clars, methodDecl, mv);
        if (index != -1)
            if (this.type.equals(Type.STRING))
                mv.visitVarInsn(ASTORE, index);
            else
                mv.visitVarInsn(ISTORE, index);
        else
            mv.visitFieldInsn(PUTFIELD, clars.className, name, this.type.getASMDescriptor());
    }
}