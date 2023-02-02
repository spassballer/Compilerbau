package semantic_check;

import java.util.Map;
import java.util.Vector;
import org.objectweb.asm.*;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

public class Field {
    Type type;
    Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses) {
        return null;
    }
    String name;

    public void codeGen(ClassWriter cw) throws Exception {
        cw.visitField(ACC_PUBLIC, name, type.getASMDescriptor(), null, null).visitEnd();
    }
}
