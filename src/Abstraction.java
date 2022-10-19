import java.util.ArrayList;
import java.util.List;

public class Abstraction implements LambdaExpression {

    public final Variable header;
    public final LambdaExpression body;

    public Abstraction(Variable header, LambdaExpression body) {
        this.header = header;
        this.body = body;
    }

    public LambdaExpression apply(LambdaExpression t) {
        return null;
    }

    @Override
    public List<LambdaExpression> freeIdentifier() {
        List<LambdaExpression> list = new ArrayList<LambdaExpression>();
        for (LambdaExpression e : body.freeIdentifier()) {
            list.add(e);
        }
        while (list.remove(header));
        return list;
    }

    @Override
    public LambdaExpression reduce() {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

}
