package semantic_check;
import java.util.HashMap;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class Clars {
    Type name;
    FieldDecl[] fields;
    MethodDecl[] methods;
    String className;

    public Clars(Type type, FieldDecl[] fields, MethodDecl[] methods){
        this.name = type;
        this.fields = fields;
        this.methods = methods;
        this.className = type.type;
    }

    Type typeCheck(){
        Clars clars = this;
        for(FieldDecl field : fields){
            field.typeCheck(new HashMap<>(),clars);
        }
        for(MethodDecl methode : methods){
            methode.typeCheck(new HashMap<>(),clars);
        }
        return name;
    }

    public void codeGen() throws Exception {
        ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

        cw.visit(Opcodes.V1_8,
                Opcodes.ACC_PUBLIC,
                className,
                null,
                "java/lang/Object",
                null);

        for (FieldDecl fieldDecl : fields) {
            fieldDecl.codeGen(cw);
        }
        for (MethodDecl methodDecls : methods) {
            methodDecls.codeGen(cw);
        }
    }
}
