import java.util.HashSet;
import java.util.Set;

public class Variable implements Expression {
    
    public final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Set<Expression> freeIdentifiers() {
        Set<Expression> fi = new HashSet<>();
        fi.add(this);
        return fi;
    }

    @Override
    public boolean reducable() {
        return false;
    }

    @Override
    public Expression reduce() {
        return this;
    }

    public Variable conversion() {
        return new Variable(name + "'");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Variable)) return false;

        Variable var = (Variable) o;

        return this.name.equals(var.name);
    }
}
