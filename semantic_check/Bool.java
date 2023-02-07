package semantic_check;

import java.util.Map;

public class Bool extends Expression {
    boolean bool;

    public Bool(boolean bool) {
        this.bool = bool;
    }

    @Override
    Type typeCheck(Map<String, Type> localvars, Clars clars) {
        return Type.BOOLEAN;
    }
}
