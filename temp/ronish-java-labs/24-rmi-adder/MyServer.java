import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class MyServer extends UnicastRemoteObject implements Adder {

    public MyServer() throws RemoteException {
        super();
    }

    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.createRegistry(5000);
        reg.rebind("hiserver", new MyServer());
        System.out.println("Server is ready on port 5000...");
    }
}
