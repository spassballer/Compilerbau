package semantic_check;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class Block {
    Statement[] statements;

    public void codeGen(MethodVisitor mv){
        for (Statement statement: statements){
            statement.statement.codeGen(mv);
        }
    }
}
