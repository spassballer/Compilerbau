package semantic_check;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class InstVar extends Expression{

    Expression expression;
    String name;

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        Type exprType = expression.typeCheck(localvars, clars);
        if (exprType.equals(Type.BOOLEAN)
                || exprType.equals(Type.CHAR)
                || exprType.equals(Type.INTEGER)
                || exprType.equals(Type.VOID)
                || exprType.equals(Type.NULL)) {
            if(exprType.equals(clars.name)){
                for(FieldDecl field : clars.fields){
                    if(field.name.equals(name)){
                        return field.type;
                    }
                }
                //TODO Exception: Class does not contain variable name
            }
            //TODO Exception: Expression is not equal to expected class type
        }
        //TODO Exception: Expression must be a valid Class type
        return null;
    }
    @Override
    void codeGen(MethodVisitor mv) {

    }
}