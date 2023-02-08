package semantic_check;



import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;
import java.util.Vector;

public class If {
    Expression cond;
    Statement ifStmt;
    Statement elseStmt;

    Type typeCheck(Map<String, Type> localVars, Vector<Class> classes) {
        if (cond.typeCheck(localVars, classes).equals(new Type("boolean"))
                && ifStmt.typeCheck(localVars, classes)
                .equals(elseStmt.typeCheck(localVars, classes))) {
            var typ = ifStmt.typeCheck(localVars, classes);
            return typ;
        } else {
            return null;
        }
    }

    void codeGen(MethodVisitor mv){

        Label skipIfLabel = new Label();
        Label skipElseLabel = new Label();

        cond.codeGen(mv); //Load condition to stack: Still TODO

        if(cond instanceof Bool){
            mv.visitJumpInsn(Opcodes.IFEQ, skipIfLabel);
        } else if(cond instanceof Binary){
            Binary binaryCond = (Binary) cond;
            binaryCond.codeGen(mv);
        }

        //IF BLOCK
        ifStmt.codeGen(mv);

        if(elseStmt == null){ //else block does not exist, only have to visit Label for end of if block
            mv.visitLabel(skipIfLabel);
        } else {
            /*
            Else Block does exist.
            If inside if block: jump to end of else block
            Visit Label for else Block, generate Bytecode for else block, visit label for end of else block
             */
            mv.visitJumpInsn(Opcodes.GOTO, skipElseLabel);
            mv.visitLabel(skipIfLabel);
            if(elseStmt != null){
                elseStmt.codeGen(mv);
                mv.visitLabel(skipElseLabel);
            }
        }


    }
}