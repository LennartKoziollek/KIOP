public class App {
    public static void main(String[] args) throws Exception {

        
        // ((lambda x.x) y) in code form
        Variable x = new Variable("x");
        Variable y = new Variable("y");

        Abstraction lambda = new Abstraction(x, x);
        Application application = new Application(lambda, y); // not sure what this is for yet

        application.reduce(); //was macht jetzt eigentlich reduce?
        lambda.apply(y);


    }
}
