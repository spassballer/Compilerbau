package semantic_check;

import org.objectweb.asm.ClassWriter;

public class Block {
    Statement[] statements;

    public void codeGen(ClassWriter cw){
        for (Statement statement: statements){
            statement.statement.codeGen(cw);
        }
    }
}
