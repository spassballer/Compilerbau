package codegenerierung;

import java.util.Vector;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class Class{
    Type name;
    Vector<Field> fields;
    Vector<Method> methods;


    

    void typeCheck(){

    }
    
    void codeGen(){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, name.getInternalName(), null, "java/lang/Object", null);

        for(Field field: fields){ field.codeGen(cw); }
        for(Method method: methods) { method.codeGen(cw); }

        //writeClassFile();
    }
}