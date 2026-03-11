import java.io.FileWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a string: ");
        String inputString = scanner.next();
        scanner.close();
        String lcStr = inputString.toLowerCase();
        String vowelString = "";
        String consonantString = "";
        for (int i = 0; i < inputString.length(); i++) {
            if (lcStr.charAt(i) == 'a' || lcStr.charAt(i) == 'e' || lcStr.charAt(i) == 'i' || lcStr.charAt(i) == 'o'
                    || lcStr.charAt(i) == 'u') {
                vowelString += inputString.charAt(i);
            } else {
                consonantString += inputString.charAt(i);
            }
        }

        try {
            FileWriter vowelWriter = new FileWriter("./Vowel.txt");
            vowelWriter.write(vowelString);
            vowelWriter.close();

            FileWriter consonantWriter = new FileWriter("./Consonant.txt");
            consonantWriter.write(consonantString);

            consonantWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}