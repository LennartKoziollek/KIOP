import java.util.List;

public interface LambdaExpression {

    public List<LambdaExpression> freeIdentifier();

    public LambdaExpression reduce();

    public String getName();

}