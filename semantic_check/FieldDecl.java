

import org.objectweb.asm.ClassWriter;

import java.util.ArrayList;
import java.util.Map;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

public class FieldDecl {
    String name;
    Type type;

    public FieldDecl(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    void typeCheck(Map<String, Type> localVars, Clars clars) {
        if (!(type.equals(Type.BOOLEAN)
                || type.equals(Type.CHAR)
                || type.equals(Type.INT)
                || type.equals(Type.STRING)
                || type.equals(Type.CLASSTYPE))) {
            throw new InvalidTypeException("Field" + name + "has an invalid type: " + type);
        }
        ArrayList<FieldDecl> fieldList = new ArrayList();
        for (FieldDecl field : clars.fields) {
            if (fieldList.contains(field)) {
                throw new DuplicateException("The Field: " + name + " does already exists");
            }
            fieldList.add(field);
        }
    }

    public void codeGen(ClassWriter cw) throws Exception {
        cw.visitField(ACC_PUBLIC, name, type.getASMDescriptor(), null, null).visitEnd();
    }
}