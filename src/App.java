public class App {
    public static void main(String[] args) throws Exception {

        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Application a = new Application(y, y);
        Abstraction abstr = new Abstraction(x, a);

        
        System.out.println("Header: " + abstr.header.getName());
        abstr.freeIdentifier().forEach((e) -> System.out.println("Free: " + e.getName()));

    }
}
