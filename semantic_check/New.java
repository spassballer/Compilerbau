
import org.objectweb.asm.MethodVisitor;

import java.util.Map;
import java.util.Vector;

import static org.objectweb.asm.Opcodes.*;

public class New extends StmtExpr {

    Type type;
    Vector<Expression> expressions;

    public New(Type type, Vector<Expression> expressions) {
        this.type = type;
        this.expressions = expressions;
    }

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if (type.equals(Type.BOOLEAN)
                || type.equals(Type.CHAR)
                || type.equals(Type.INT)
                || type.equals(Type.VOID)
                || type.equals(Type.NULL)
                || type.equals(Type.CLASSTYPE)) {
            if (type.equals(clars.name)) {
                if (expressions.size() == 0) {
                    return type;
                }
                throw new ParameterException("Parameters must be empty.");
            }
            throw new InvalidTypeException("Type " + type + "does not match classtype " + clars.name);
        }
        throw new InvalidTypeException("Invalid class Type " +  type);
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        String newType = "";

        if (Type.STRING.equals(type)) {
            newType = "java/lang/String";
        } else if (Type.OBJECT.equals(type)) {
            newType = "java/lang/Object";
        }  else if(Type.CLASSTYPE.equals(type)){
            newType = type.type;
        }

        mv.visitTypeInsn(NEW, newType);
        mv.visitInsn(DUP);

        StringBuilder sb = new StringBuilder();
        for (Expression exp : expressions) {
            exp.codeGen(clars, methodDecl, mv);
            sb.append(exp.type.getASMDescriptor());
        }

        mv.visitMethodInsn(INVOKESPECIAL, newType, "<init>", "(" + sb + ")V", false);
    }

}