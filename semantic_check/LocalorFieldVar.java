package semantic_check;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Vector;

public class LocalorFieldVar extends Expression{
    String local;

    @Override
    public semantic_check.Type typeCheck(Map<String, Type> localvars, Vector<Class> clarses) {
        return null;
        //TODO ausprogrammieren
    }
}
