

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import static org.objectweb.asm.Opcodes.*;

public class MethodDecl {
    public String name;
    public Type returnType;
    public Vector<Parameter> parameters;
    public Block block;
    Vector<LocalOrFieldVar> localVar = new Vector<LocalOrFieldVar>();

    public MethodDecl(String name, Type returnType, Vector<Parameter> parameters, Block block) {
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.block = block;
    }


    /**
     * @return returns -1 if the local variable is not found
     */
    public int getIndexOfLocalVarByName(String nameOfLocalVarToSearch){
        return this.localVar.indexOf(new LocalOrFieldVar(nameOfLocalVarToSearch));
    }

    public Type typeCheck(Map<String, Type> localVars, Clars clars) {
        ArrayList<MethodDecl> methodList = new ArrayList();
        for (MethodDecl method : clars.methods) {
            if (methodList.contains(method)) {
                throw new DuplicateException("The method: " + name +" already exists");
            }
            methodList.add((method));
        }
        if (!(returnType.equals(Type.BOOLEAN)
                || returnType.equals(Type.CHAR)
                || returnType.equals(Type.INT)
                || returnType.equals(Type.STRING)
                || returnType.equals(Type.VOID))) {
            throw new InvalidTypeException("The return type: " + returnType+" is invalid");
        }
        for (Parameter parameter: parameters){
            parameter.typeCheck(localVars,clars);
            localVars.put(parameter.name,parameter.type);
        }
        Type blockType = block.typeCheck(localVars,clars);
        if (!blockType.equals(returnType)){
            throw new InvalidTypeException("The return type " +returnType +" doesnt match with type of method block " + blockType);
        }
        return returnType;
    }

    public void codeGen(ClassWriter cw, Clars clars) throws Exception {
        localVar.add(new LocalOrFieldVar("this"));
        StringBuilder parameterTypes = new StringBuilder();
        for (Parameter parameter : parameters) {
            parameterTypes.append(parameter.type.getASMDescriptor());
            parameter.codeGen(this);
        }
        String descriptor = "("+parameterTypes+")"+returnType.getASMDescriptor();
        MethodVisitor mv = cw.visitMethod(
                ACC_PUBLIC,
                name,
                descriptor,
                null,
                null
        );
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        block.codeGen(clars, this, mv);
        if(returnType.equals(Type.VOID)){
            mv.visitInsn(RETURN);
        }
        mv.visitMaxs(-1, -1);
        mv.visitEnd();
    }
}

