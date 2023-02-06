package semantic_check;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class Clars {
    String name;
    FieldDecl[] fieldDecls;
    MethodDecl[] methodDecls;

    public void codeGen() throws Exception {
        ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

        cw.visit(Opcodes.V1_8,
                Opcodes.ACC_PUBLIC,
                name,
                null,
                "java/lang/Object",
                null);

        for (FieldDecl fieldDecl : fieldDecls) {
            fieldDecl.codeGen(cw);
        }
        for (MethodDecl methodDecls : methodDecls) {
            methodDecls.codeGen(cw);
        }
    }
}
