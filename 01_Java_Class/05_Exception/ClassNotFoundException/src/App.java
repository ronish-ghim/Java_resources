public class App {
    public static void main(String[] args) throws Exception {
         try {
            Class.forName("com.example.UnknownClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException handled: " + e.getMessage());
        }
    }
}
