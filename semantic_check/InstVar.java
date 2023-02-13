

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

import static org.objectweb.asm.Opcodes.GETFIELD;

public class InstVar extends Expression {

    Expression expression;
    String name;

    public InstVar(Expression expression, String name) {
        this.expression = expression;
        this.name = name;
    }
    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        Type exprType = expression.typeCheck(localvars, clars);
        if (exprType.equals(Type.CLASSTYPE)) {
            for (FieldDecl field : clars.fields) {
                if (field.name.equals(name)) {
                    type = field.type;
                    return type;
                }
            }
            throw new NotDeclaredException("The field: " + name +" is not declared in class: " + clars.className);
        }
        throw new InvalidTypeException("The expression type: " + name +" doesnt match class: " + clars.className );
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        expression.codeGen(clars, methodDecl, mv);
        mv.visitFieldInsn(GETFIELD, clars.className, name, type.getASMDescriptor());
    }
}
