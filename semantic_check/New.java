
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
                || type.equals(Type.NULL)) {
            if(type.equals(clars.name)){
                if(expressions.isEmpty()){
                    return type;
                }
                //TODO Exception No parameters allowed in empty Constructor
            }
            //TODO Exception not expected Classtype
        }
        //TODO Exception invalid type
        return null;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        String newType = "";

        if (Type.STRING.equals(type)) {
            newType = "java/lang/String";
        } else if (Type.OBJECT.equals(type)) {
            newType = "java/lang/Object";
        }

        mv.visitTypeInsn(NEW, newType);
        mv.visitInsn(DUP);

        StringBuilder sb = new StringBuilder();
        for(Expression exp: expressions){
            exp.codeGen(clars, methodDecl, mv);
            sb.append(exp.type.getASMDescriptor());
        }

        mv.visitMethodInsn(INVOKESPECIAL, newType, "<init>", "("+sb+")V", false);
    }

}