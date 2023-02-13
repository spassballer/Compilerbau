

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;
import java.util.Vector;

public class MethodCall extends StmtExpr implements Opcodes {

    Expression expr;
    String name;
    Vector<Expression> expressions;

    public MethodCall(Expression expr, String name, Vector<Expression> expressions) {
        this.expr = expr;
        this.name = name;
        this.expressions = expressions;
    }

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        MethodDecl myMethodDecl = null;
        for(MethodDecl method : clars.methods){
            if(method.name.equals(name)){
                myMethodDecl = method;
            }
        }
        if(myMethodDecl == null){
            throw new NotDeclaredException("Method " + name + " does not exist in this class");
        }
        if(expressions.length!=myMethodDecl.parameters.length){
            throw new ParameterException("Method " + name + " expects " + myMethodDecl.parameters.length + " parameters, but got " + expressions.length);
        }
        for(int i = 0; i<expressions.length; i++){
            if(!expressions[i].type.equals(myMethodDecl.parameters[i].type)){
                throw new ParameterException("Expected parameter type" + myMethodDecl.parameters[i].type + ", but got " + expressions[i].type);

            }
        }
        return myMethodDecl.returnType;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        StringBuilder parameterTypes = new StringBuilder();
        String descriptor = null;
        for (Expression expression : expressions)
            parameterTypes.append(expression.type.getASMDescriptor());
        for (MethodDecl method : clars.methods)
            if (this.name.equals(method.name))
                descriptor = "("+parameterTypes+")"+ method.returnType.getASMDescriptor();
        if (descriptor == null)
            throw new Exception("Could not find method declaration for: " + this.name);

        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKEVIRTUAL, clars.className, name, descriptor, false);
    }

}
