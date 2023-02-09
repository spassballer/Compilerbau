package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Block extends Statement{

    Statement[] stm;
    Statement firstStmt;

    public Block(Statement firstStmt, Statement[] stm){
        this.firstStmt = firstStmt;
        this.stm = stm;
    }

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if(stm.length==0){
            return firstStmt.typeCheck(localVars, clars);
        }
        Statement[] nextStm = new Statement[stm.length-1];
        if (nextStm.length - 1 >= 0) System.arraycopy(stm, 1, nextStm, 0, nextStm.length - 1);
        if(firstStmt==null){
            return new Block(stm[0],nextStm).typeCheck(localVars, clars);
        }
        if(firstStmt.typeCheck(localVars,clars).equals(new Block(stm[0],nextStm).typeCheck(localVars, clars))){
            return firstStmt.typeCheck(localVars, clars);
        }
        //TODO Exception
        return null;
    }

    @Override
    public void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        firstStmt.codeGen(clars, methodDecl, mv);
        for (Statement statement: stm){
            statement.codeGen(clars, methodDecl, mv);
        }
    }
}
