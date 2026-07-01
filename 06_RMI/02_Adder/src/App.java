
// server: bind the adder 
// import java.rmi.*;
import java.rmi.registry.*;

public class App {
    public static void main(String[] args) throws Exception {
        IAdder stub = new Adder();
        Registry reg = LocateRegistry.createRegistry(4099);
        reg.rebind("AdderService", stub);
        System.out.println("AdderService Rebound successfully");

    }
}
