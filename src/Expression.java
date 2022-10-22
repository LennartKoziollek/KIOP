import java.util.List;

public interface Expression {

    public boolean reducable();

    public Expression reduce();

    //not sure about that one yet
    public List<Expression> freeIdentifier();

}