import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            FileInputStream file = new FileInputStream("abc.txt");
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException handled: " + e.getMessage());
        }
    }
}
