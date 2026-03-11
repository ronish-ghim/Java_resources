public class App {
    public static void main(String[] args) throws Exception {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException handled: " + e.getMessage());
        }
    }
}
