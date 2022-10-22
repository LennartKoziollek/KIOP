public class App {
    public static void main(String[] args) throws Exception {

        Variable x = new Variable("x");
        Variable y = new Variable("y");

        Abstraction abs = new Abstraction(x, y);

        System.out.println(abs.freeIdentifiers().toString());
        
    }
}
