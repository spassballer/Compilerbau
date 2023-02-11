package semantic_check;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

import static org.objectweb.asm.Opcodes.*;

public class New extends StmtExpr {

    Type type;
    Expression[] expressions;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if (type.equals(Type.BOOLEAN)
                || type.equals(Type.CHAR)
                || type.equals(Type.INT)
                || type.equals(Type.VOID)
                || type.equals(Type.NULL)) {
            if(type.equals(clars.name)){
                if(expressions.length == 0){
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
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception { //TODO alles TODO, keine Ahnung, ob das klappt
        mv.visitTypeInsn(NEW, type.getASMDescriptor());
        mv.visitInsn(DUP);

        for(Expression exp: expressions){ //TODO muss das vielleicht als erstes ausgeführt werden?
            exp.codeGen(clars, methodDecl, mv);
        }

        mv.visitMethodInsn(INVOKESPECIAL, type.getASMDescriptor(), "<init>", "()V", false); //TODO ist getASMDescriptor hier richtig? Ist ()V hier richtig?
    }

}