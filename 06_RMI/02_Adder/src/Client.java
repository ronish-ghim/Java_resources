
import java.rmi.registry.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost", 4099);
        IAdder stub = (IAdder) reg.lookup("AdderService");
        System.out.println(stub.add(3, 5));
    }

}