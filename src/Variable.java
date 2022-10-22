import java.util.ArrayList;
import java.util.List;

public class Variable implements Expression {

    public final String name;

    public Variable(String varname) {
        this.name = varname;
    }

    @Override
    public List<Expression> freeIdentifier() {
        List<Expression> list = new ArrayList<Expression>();
        list.add(this);
        return list;
    }

    @Override
    public Variable reduce() {
        return this;
    }

    @Override
    public boolean reducable() {
        return false;
    }

    // maybe i need a equals method

}
