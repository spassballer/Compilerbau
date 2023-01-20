package semantic_check;

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
}
