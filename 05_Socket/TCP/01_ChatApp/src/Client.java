import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        try {
            BufferedReader socketIn = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter socketOut = new PrintWriter(s.getOutputStream(), true);
            BufferedReader sysIn = new BufferedReader(
                    new InputStreamReader(System.in));

            String msg;
            while (true) {
                System.out.print("You: ");
                msg = sysIn.readLine();
                socketOut.println(msg);

                msg = socketIn.readLine();
                System.out.println("Server: " + msg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

    }
}