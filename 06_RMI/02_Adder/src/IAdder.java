// create an interface
import java.rmi.*;

public interface IAdder extends Remote {
    public  int add(int x, int y) throws RemoteException;
}