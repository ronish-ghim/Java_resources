public class App {
    public static void main(String[] args) throws Exception {

        // taking input from user
        String name = System.console().readLine("Enter your name: ");
        int age = Integer.parseInt(System.console().readLine("Enter your age: "));
        System.out.println("Hello " + name + "!");
        if (age > 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }
    }

}
