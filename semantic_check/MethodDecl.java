package semantic_check;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


public class MethodDecl {
    Method method;

    public void codeGen(ClassWriter cw) throws Exception {
        StringBuilder parameterTypes = new StringBuilder();
        for (Field field : method.parameters) {
            parameterTypes.append(field.type.getASMDescriptor());
        }
        String descriptor = "("+parameterTypes+")"+method.type.getASMDescriptor();

        MethodVisitor mv = cw.visitMethod(
                Opcodes.ACC_PUBLIC,
                method.name,
                descriptor,
                null,
                null
        );
        for (Field field : method.parameters) {
            mv.visitParameter(field.name, Opcodes.ACC_PRIVATE);
        }

        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                "java/lang/Object",
                method.name,
                descriptor,
                false
        );
        method.stmt.codeGen(cw);
        mv.visitMaxs(-1, -1);
        mv.visitEnd();
    }
}
