import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        String directoryPath = "C:\\Users\\Rons\\OneDrive\\Desktop\\Coding";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
