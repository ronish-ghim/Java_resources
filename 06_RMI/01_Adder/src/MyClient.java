import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    public static void main(String[] args) throws Exception {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 5000);
            Adder adder = (Adder) reg.lookup("hiserver");
            System.out.println(adder.add(10, 10));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
