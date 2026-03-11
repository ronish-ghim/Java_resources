public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\t\tCalculator Application");
        System.out.println("Enter two numbers to perform an operation:");

        int num1 = Integer.parseInt(System.console().readLine("Enter first number: "));
        int num2 = Integer.parseInt(System.console().readLine("Enter second number: "));

        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int choice = Integer.parseInt(System.console().readLine("Enter your choice (1-4): "));

        int result = 0;

        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case 4:
                if (num2 != 0) {
                    double divResult = (double) num1 / num2;
                    System.out.println("Result: " + divResult);
                } else {
                    // exception handling for division by zero
                    throw new ArithmeticException("Division by zero is not allowed.");

                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
