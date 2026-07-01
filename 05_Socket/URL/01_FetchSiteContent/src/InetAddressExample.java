import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) throws Exception {
        InetAddress[] add = InetAddress.getAllByName("www.google.com");
        for (InetAddress address : add) {
            System.out.println("IPV4 address : " + address.getHostAddress());
        }
    }
}