import java.util.HashSet;
import java.util.Set;

public class Application implements Expression {

    public final Expression left;
    public final Expression right;

    public Application(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Set<Expression> freeIdentifiers() {

        Set<Expression> fi = new HashSet<>();

        fi.addAll(left.freeIdentifiers());
        fi.addAll(right.freeIdentifiers());

        return fi;
    }

    @Override
    public boolean reducable() {

        // im not sure about this yet
        return left.reducable() || right.reducable() || left instanceof Abstraction;

    }

    @Override
    public Expression reduce() {

        // looks through if left or right can be reduced and reduces them
        // is else if is working here because the deep reduce function goes through them
        // all and the reduce function should only reduce 1 step at a time
        if (left.reducable()) {
            return new Application(left.reduce(), right);
        } else if (right.reducable()) {
            return new Application(left, right.reduce());
        } else if (left instanceof Abstraction) {
            // substitution part here

            Abstraction leftabs = (Abstraction) left;
            subsitute(leftabs.header, leftabs.body, right);

        }

        // in case this is not reducable it is giving back the original Expression
        return this;
    }

    /*
     * Example cases
     * (lambda x.y) z
     * (lambda x.((lambda b.b) a)) z
     * 
     */
    private Expression subsitute(Variable leftheader, Expression leftbody, Expression right) {
        if (leftbody instanceof Variable) {
            /*
             * (lambda x.x) z
             * (lambda x.y) z
             */
            if (leftheader.equals(leftbody)) { // TODO equals implementation
                return right;
            } else {
                return leftbody;
            }

            /*
             * (Lambda x.(a a)) z
             * 
             */
        } else if (leftbody instanceof Application) {
            Application application = (Application) leftbody;

            //TODO
            return new Application(subsitute(leftheader, application.left, application.right), subsitute(leftheader, innerleftbody, right));

        }
    }

}
