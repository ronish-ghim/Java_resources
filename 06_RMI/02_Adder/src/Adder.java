// implement the interface

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Adder extends UnicastRemoteObject implements IAdder{
    Adder() throws RemoteException{
        super();
    }
    
    public int add(int x, int y) {return x+y;}
}