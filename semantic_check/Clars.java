package semantic_check;
import java.util.HashMap;

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
        for(FieldDecl field : fields){
            field.typeCheck(new HashMap<>(),clars);
        }
        for(MethodDecl methode : methods){
            methode.typeCheck(new HashMap<>(),clars);
        }
        return name;
    }

}