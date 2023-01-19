package codegenerierung;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

public class Field {

    String fieldName; //var name
    String descriptor;//I: Int

    void codeGen(ClassWriter cw) {
        FieldVisitor fv = cw.visitField(Opcodes.ACC_PRIVATE, fieldName, descriptor, null, null); 
        fv.visitEnd();
    }
    
}
