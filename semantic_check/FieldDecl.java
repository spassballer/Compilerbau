package semantic_check;

import org.objectweb.asm.ClassWriter;

import java.util.Map;
import java.util.Vector;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

public class FieldDecl {
    Field field;
    Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses) {
        return null;
    }

    public void codeGen(ClassWriter cw) throws Exception {
        cw.visitField(ACC_PUBLIC, field.name, field.type.getASMDescriptor(), null, null).visitEnd();
    }
}
