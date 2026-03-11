import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
        String sourcePath = "./assets";
        String destinationPath = "./assets";
        File directory = new File(sourcePath);
        File[] files = directory.listFiles();
        Path htmlPath = Paths.get(destinationPath + "/html");
        Path cssPath = Paths.get(destinationPath + "/css");
        try {
            for (File file : files) {
                if (file.getName().endsWith(".html")) {

                    Files.copy(file.toPath(), htmlPath.resolve(file.getName()));
                } else if (file.getName().endsWith(".css")) {
                    Files.copy(file.toPath(), cssPath.resolve(file.getName()));

                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
