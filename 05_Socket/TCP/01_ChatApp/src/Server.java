import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();
        try {

            BufferedReader socketIn = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter socketOut = new PrintWriter(s.getOutputStream(), true);
            BufferedReader sysIn = new BufferedReader(
                    new InputStreamReader(System.in));

            String msg;

            while (true) {

                msg = socketIn.readLine();
                System.out.println("Client: " + msg);

                System.out.print("You: ");
                msg = sysIn.readLine();
                socketOut.println(msg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ss.close();
            s.close();
        }
    }
}