

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class If extends Statement {
    Expression cond;
    Statement ifStmt;
    Statement elseStmt;

    public If(Expression cond, Statement ifStmt, Statement elseStmt) {
        this.cond = cond;
        this.ifStmt = ifStmt;
        this.elseStmt = elseStmt;
    }

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if (cond.typeCheck(localVars, clars).equals(new Type("boolean"))
                && ifStmt.typeCheck(localVars, clars)
                .equals(elseStmt.typeCheck(localVars, clars))) {
            var typ = ifStmt.typeCheck(localVars, clars);
            return typ;
        } else {
            return null;
        }
    }


    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {

        Label skipIfLabel = new Label();
        Label skipElseLabel = new Label();

        cond.codeGen(clars, methodDecl, mv); //Load condition to stack: Still TODO?
        mv.visitJumpInsn(Opcodes.IFEQ, skipIfLabel);


        //IF BLOCK
        ifStmt.codeGen(clars, methodDecl, mv);

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
            elseStmt.codeGen(clars, methodDecl, mv);
            mv.visitLabel(skipElseLabel);

        }


    }
}