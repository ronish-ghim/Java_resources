import java.rmi.*;
import java.rmi.registry.*;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost", 5000);
        Adder adder = (Adder) reg.lookup("hiserver");
        int result = adder.add(20, 30);
        System.out.println("Sum = " + result);
    }
}
