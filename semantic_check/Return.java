import java.util.Map;

public class Return extends Statement{

    Expression expression;

    @Override
    Type typeCheck(Map<String, Type> localVars, Clars clars) {
        return expression.typeCheck(localVars, clars);
    }

}