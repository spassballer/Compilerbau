

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
        if (cond.typeCheck(localVars, clars).equals(new Type("boolean"))) {
            Type ifType = ifStmt.typeCheck(localVars,clars);
            if(elseStmt == null){
                type = ifType;
                return type;
            }
            Type elseType = elseStmt.typeCheck(localVars, clars);
            if (ifType.equals(elseType)) {
                type = ifType;
                return type;
            }
            throw new InvalidTypeException("If type " + ifType + " doesn't match else Type " + elseType);
        }
        throw new InvalidTypeException("Condition " + cond + " is not a boolean");
    }


    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {

        Label skipIfLabel = new Label();
        Label skipElseLabel = new Label();

        cond.codeGen(clars, methodDecl, mv);
        mv.visitJumpInsn(Opcodes.IFEQ, skipIfLabel);


        //IF BLOCK
        ifStmt.codeGen(clars, methodDecl, mv);

            /*
            Else Block does exist.
            If inside if block: jump to end of else block
            Visit Label for else Block, generate Bytecode for else block, visit label for end of else block
             */
        if (elseStmt != null)
            mv.visitJumpInsn(Opcodes.GOTO, skipElseLabel);
        mv.visitLabel(skipIfLabel);
        if (elseStmt != null)
            elseStmt.codeGen(clars, methodDecl, mv);
        mv.visitLabel(skipElseLabel);



        /*
        elseStmt == null:
        Condition überprüfen: true oder false?
        Wenn true:
            Statement ausführen
        Wenn false:
            Statement überspringen
         */

        /*
        elseStmt != null:
        Condition überprüfen: true oder false?
        Wenn true:
            Statement ausführen
            Else State überspringen
        Wenn false:
            Statement überspringen
            Else Statement ausführen
         */

    }
}