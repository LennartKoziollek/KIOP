import java.util.ArrayList;
import java.util.List;

public class Application implements LambdaExpression {

    // t1 t2
    // right is being put into the header of left
    public final LambdaExpression left;
    public final LambdaExpression right;

    public Application(LambdaExpression left, LambdaExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public List<LambdaExpression> freeIdentifier() {

        List<LambdaExpression> list = new ArrayList<LambdaExpression>();
        for (LambdaExpression e : left.freeIdentifier()) {
            list.add(e);
        }

        for (LambdaExpression e : right.freeIdentifier()) {
            list.add(e);
        }

        return list;
    }

    @Override
    public LambdaExpression reduce() {

        Variable v;

        if(!(right instanceof Variable)) {
            v = (Variable) right.reduce();
        }

        //TODO i am here

        return null;
    }

    @Override
    public String getName() {
        return null;
    }

}
