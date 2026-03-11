public class App {
    public static void main(String[] args) throws Exception {
        int number = Integer.parseInt(System.console().readLine("Enter a positive integer: "));
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    static boolean isPrime(int number) {
        if (number <= 2)
            return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}