import java.util.Set;

public interface Expression {
    
    public Set<Expression> freeIdentifiers();

    public boolean reducable();
    
    // basically means beta reduction
    public Expression reduce();

}
