import java.util.ArrayList;
import java.util.List;

public class Application implements Expression {

    // t1 t2
    // right is being put into the header of left
    public final Expression left;
    public final Expression right;

    public Application(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public List<Expression> freeIdentifier() {

        List<Expression> list = new ArrayList<Expression>();
        for (Expression e : left.freeIdentifier()) {
            list.add(e);
        }

        for (Expression e : right.freeIdentifier()) {
            list.add(e);
        }

        return list;
    }

    @Override
    public Expression reduce() {

        return null;
    }


    @Override
    public boolean reducable() {
        // TODO Auto-generated method stub
        return false;
    }

}
