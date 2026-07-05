# Module 06 — RMI

## Sub-programs

### 1. Adder 01
**Path:** `01_Adder/src/App.java`
**Path:** `01_Adder/src/Adder.java`
**Path:** `01_Adder/src/MyServer.java`
**Path:** `01_Adder/src/MyClient.java`

```java
// App.java
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

// Adder.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Adder extends Remote {
    public int add(int x, int y) throws RemoteException;
}

// MyServer.java
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class MyServer extends UnicastRemoteObject implements Adder {
    MyServer() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.createRegistry(5000);
        reg.rebind("hiserver", new MyServer());
        System.out.println("Server is ready.");
    }
}

// MyClient.java
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
```

### 2. Adder 02
**Path:** `02_Adder/src/App.java`
**Path:** `02_Adder/src/Adder.java`
**Path:** `02_Adder/src/IAdder.java`
**Path:** `02_Adder/src/Client.java`

```java
// App.java

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

// Adder.java
// implement the interface

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Adder extends UnicastRemoteObject implements IAdder{
    Adder() throws RemoteException{
        super();
    }

    public int add(int x, int y) {return x+y;}
}

// IAdder.java
// create an interface
import java.rmi.*;

public interface IAdder extends Remote {
    public  int add(int x, int y) throws RemoteException;
}

// Client.java

import java.rmi.registry.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost", 4099);
        IAdder stub = (IAdder) reg.lookup("AdderService");
        System.out.println(stub.add(3, 5));
    }
}
```
