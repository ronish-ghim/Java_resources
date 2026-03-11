import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class App {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        String message = "Hello, UDP Server!";

        byte[] sbuffer = message.getBytes();

        InetAddress serverAddress = InetAddress.getByName("localhost");
        DatagramPacket sendPacket = new DatagramPacket(sbuffer, sbuffer.length, serverAddress, 5000);

        clientSocket.send(sendPacket);
        clientSocket.close();
    }
}
