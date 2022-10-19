import java.util.ArrayList;
import java.util.List;

public class Variable implements LambdaExpression {

    public final String name;

    public Variable(String varname) {
        this.name = varname;
    }

    @Override
    public List<LambdaExpression> freeIdentifier() {
        List<LambdaExpression> list = new ArrayList<LambdaExpression>();
        list.add(this);
        return list;
    }

    @Override
    public Variable reduce() {
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

}
