import java.util.ArrayList;
import java.util.List;

public class Abstraction implements Expression {

    public final Variable header;
    public final Expression body;

    public Abstraction(Variable header, Expression body) {
        this.header = header;
        this.body = body;
    }

    public boolean reducable() {
        return this.body.reducable();
    }

    public Expression apply(Expression t) {

        if(t instanceof Variable) {

        } else if(t instanceof Application) {

        } else { // t instance of Abstraction
            
        }

        return null;
    }

    @Override
    public List<Expression> freeIdentifier() {
        List<Expression> list = new ArrayList<Expression>();
        for (Expression e : body.freeIdentifier()) {
            list.add(e);
        }
        while (list.remove(header));
        return list;
    }

    @Override
    public Expression reduce() {

        if(this.body.reducable()) {
            return new Abstraction(this.header, this.body.reduce());
        }

        return this;
    }
}
