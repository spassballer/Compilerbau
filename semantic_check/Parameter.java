package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

class Parameter {
    public String name;
    public Type type;

    public Parameter( String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Type typeCheck(Map<String, Type> localVars, Clars clars) {
        if (!(type.equals(Type.BOOLEAN)
                || type.equals(Type.CHAR)
                || type.equals(Type.INT)
                || type.equals(Type.STRING)
                || type.equals(Type.CLASSTYPE))) {
            throw new InvalidTypeException("The type "+ type+" is invalid as parameter");

        }
        return type;
    }

    void codeGen(MethodDecl methodDecl) throws Exception {
        methodDecl.localVar.add(new LocalOrFieldVar(name));
    }
}