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
        for(int i = 1; i<nextStm.length; i++){
            nextStm[i-1] =stm[i];
        }
        if(firstStmt==null){
            return new Block(stm[0],nextStm).typeCheck(localVars, clars);
        }
        if(firstStmt.typeCheck(localVars,clars).equals(new Block(stm[0],nextStm).typeCheck(localVars, clars))){
            return firstStmt.typeCheck(localVars, clars);
        }
        //TODO Exception
        return null;
    }

}
