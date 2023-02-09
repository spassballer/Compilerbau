package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;
import java.util.Objects;

public class LocalOrFieldVar extends Expression {


    String name;

    public LocalOrFieldVar(String name) {
        this.name = name;
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        if(localvars.containsKey(name)){
            return localvars.get(name);
        }
        for(FieldDecl fieldVar : clars.fields){
            if(Objects.equals(fieldVar.name, name)){
                return fieldVar.type;
            }
        }
        // TODO Exception not defined
        return null;
    }

    @Override
    void codeGen(Clars clars, MethodDecl methodDecl, MethodVisitor mv) {
        //lade localVar/Field auf den Stack??
    }
}
