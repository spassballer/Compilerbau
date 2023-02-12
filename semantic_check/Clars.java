package semantic_check;
import java.util.HashMap;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.*;

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
        Type.CLASSTYPE = name;
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
                null
        );

        for (FieldDecl fieldDecl : fields) {
            fieldDecl.codeGen(cw);
        }
        visitStandardConstructor(cw);
        for (MethodDecl methodDecls : methods) {
            methodDecls.codeGen(cw, this);
        }
    }
    public void visitStandardConstructor(ClassWriter cw) throws Exception {
        MethodVisitor constructorVisitor = cw.visitMethod(
                ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null
        );
        constructorVisitor.visitCode();
        constructorVisitor.visitVarInsn(ALOAD, 0);
        constructorVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructorVisitor.visitInsn(RETURN);
        constructorVisitor.visitMaxs(-1, -1);
        constructorVisitor.visitEnd();
    }
}
