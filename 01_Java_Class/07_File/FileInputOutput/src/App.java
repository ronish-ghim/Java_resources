import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt");
            int c;
            while ((c = in.read()) != -1) {
                System.out.println(c);
                // out.write(c);
            }
            System.out.println("Contents copied Successfully.");
        } catch (Exception e) {
            throw e;
        }

        finally {
            in.close();
            out.close();
        }
    }
}
