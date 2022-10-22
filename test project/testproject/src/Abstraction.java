import java.util.HashSet;
import java.util.Set;

public class Abstraction implements Expression {
    
    public final Variable header;

    public final Expression body;

    public Abstraction(Variable header, Expression body) {
        this.header = header;
        this.body = body;
    }

    @Override
    public Set<Expression> freeIdentifiers() {
        
        Set<Expression> fi = new HashSet<>();
        Set<Expression> headerIdentifiers = header.freeIdentifiers();

        for(Expression e : body.freeIdentifiers()) {
            if(!headerIdentifiers.contains(e)) {
                fi.add(e);
            }
        }

        return fi;
    }

    @Override
    public boolean reducable() {

        return body.reducable();
    }

    @Override
    public Expression reduce() {

        return body.reduce();
    }



}
