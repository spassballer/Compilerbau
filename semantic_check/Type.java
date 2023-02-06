package semantic_check;

import java.util.Map;
import java.util.Objects;
import java.util.Vector;

public class Type {
    final String type;
    public static Type BOOLEAN = new Type("boolean");
    public static Type STRING = new Type("String");
    public static Type INTEGER = new Type("int");
    public static Type VOID = new Type("void");
    public static Type CHAR = new Type("char");
    public static Type NULL = new Type("null");

    public Type(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        return Objects.equals(type, type1.type);
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
        if (this.equals(INTEGER))
            return "I";
        if (this.equals(CHAR))
            return "C";
        if (this.equals(VOID))
            return "V";
        throw new Exception("Unknown type: " + this.type);
    }
}
