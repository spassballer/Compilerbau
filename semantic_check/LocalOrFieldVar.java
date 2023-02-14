

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;
import java.util.Objects;

public class LocalOrFieldVar extends Expression implements Opcodes {


    String name;

    public LocalOrFieldVar(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalOrFieldVar that = (LocalOrFieldVar) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        if(localvars.containsKey(name)){
            type = localvars.get(name);
            return type;
        }
        for(FieldDecl fieldVar : clars.fields){
            if(Objects.equals(fieldVar.name, name)){
                type = fieldVar.type;
                return type;
            }
        }
        throw new NotDeclaredException("The variable " + name +" is not declared");
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) throws Exception {
        int index = methodDecl.getIndexOfLocalVarByName(name);
        if (index != -1){
            if (!type.equals(Type.STRING))
                mv.visitVarInsn(ILOAD, index);
            else
                mv.visitVarInsn(ALOAD, index);
        }
        else {
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, clars.className, name, type.getASMDescriptor());
        }

    }
}
