package semantic_check;
import org.objectweb.asm.ClassWriter;

import java.util.Map;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

public class FieldDecl {
    String name;
    Type type;
    Object initialValue;

    public FieldDecl(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    Type typeCheck(Map<String,Type> localVars, Clars clars){
        if(!(type.equals(Type.BOOLEAN)
                || type.equals(Type.CHAR)
                || type.equals(Type.INTEGER)
                || type.equals(Type.STRING))){
            // TODO Exception
        }
        for(FieldDecl field : clars.fields){
            if(field.name.equals(name)){
                // TODO Exception
            }
        }
        return type;
    }

    public void codeGen(ClassWriter cw) throws Exception {
        cw.visitField(ACC_PUBLIC, name, type.getASMDescriptor(), null, null).visitEnd();
    }
}