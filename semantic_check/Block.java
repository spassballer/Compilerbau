

import org.objectweb.asm.MethodVisitor;

import java.util.Map;
import java.util.Vector;

public class Block extends Statement {

    Vector<Statement> stm;

    public Block(Vector<Statement> stm) {
        this.stm = stm;
    }


    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        Type blockType = Type.VOID;
        for (Statement statement : stm) {
            Type stmtType = statement.typeCheck(localVars, clars);
            if (!stmtType.equals(Type.VOID)) {
                if (blockType.equals(Type.VOID) || blockType.equals(stmtType)) {
                    blockType = stmtType;
                } else {
                    throw new InvalidTypeException("Two statements have different return types: firstType: " + blockType + " secondType: " + stmtType);
                }
            }
        }
        return blockType;
    }

    @Override
    public void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        for (Statement statement : stm) {
            statement.codeGen(clars, methodDecl, mv);
        }
    }

}
