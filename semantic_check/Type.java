
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

    public  boolean equals(Type type) {
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
        throw new Exception("Unknown type: " + this.type);
    }

    @Override
    public String toString(){
        return type;
    }
}
