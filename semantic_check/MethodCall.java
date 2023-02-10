package semantic_check;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class MethodCall extends StmtExpr implements Opcodes {

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
                //TODO Exception type mismatch
            }
        }
        return myMethodDecl.returnType;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        StringBuilder parameterTypes = new StringBuilder();
        for (Expression expression : expressions)
            parameterTypes.append(expression.type.getASMDescriptor());
        String descriptor = "("+parameterTypes+")"+expression.type.getASMDescriptor();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKEVIRTUAL, clars.className, name, descriptor, false);
        //methodVisitor.visitInsn(POP); //TODO: no assign + no void? -> pop value from stack!
    }

}
