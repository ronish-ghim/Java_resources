import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App {
    public static void main(String[] args) throws Exception {
        String page = "index.html";
        try {
            URL u = new URL("http://www.example.com");
            URLConnection uc = u.openConnection();
            uc.connect();

            InputStream in = uc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            BufferedWriter writer = new BufferedWriter(new FileWriter(page));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            in.close();
            br.close();
            writer.close();
            System.out.println("Page Downloaded successfully. " + page);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
