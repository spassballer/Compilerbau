
import java.util.Objects;

public class Type {
    final String type;
    public static Type BOOLEAN = new Type("boolean");
    public static Type STRING = new Type("String");
    public static Type INT = new Type("int");
    public static Type VOID = new Type("void");
    public static Type CHAR = new Type("char");
    public static Type NULL = new Type("null");
    public static Type THIS = new Type("this");
    public static Type OBJECT = new Type("object");
    public static Type CLASSTYPE;

    public Type(String type) {
        this.type = type;
    }

    public boolean equals(Type type) {
        if(this.type.equals(Type.STRING.type) || this.type.equals(Type.OBJECT.type) || this.type.equals(Type.CLASSTYPE.type)){
            if(type.type.equals(Type.NULL.type)){
                return true;
            }
        } else if(this.type.equals(Type.NULL.type)){
            if(type.type.equals(Type.STRING.type) || type.type.equals(Type.OBJECT.type) || type.type.equals(Type.CLASSTYPE.type)){
                return true;
            }
        }
        return this.type.equals(type.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public String getASMDescriptor() throws Exception {
        if (this.equals(BOOLEAN))
            return "Z";
        if (this.equals(STRING))
            return "Ljava/lang/String;";
        if (this.equals(INT))
            return "I";
        if (this.equals(CHAR))
            return "C";
        if (this.equals(VOID))
            return "V";
        if(this.equals(OBJECT))
            return "Ljava/lang/Object;";
        if(this.equals(CLASSTYPE))
            return "L"+ this.type +";";
        throw new Exception("Unknown type: " + this.type);
    }

    public Boolean isPrimitive() {
        if (this.equals(Type.INT))
            return true;
        if (this.equals(Type.CHAR))
            return true;
        if (this.equals(Type.BOOLEAN))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return type;
    }
}
