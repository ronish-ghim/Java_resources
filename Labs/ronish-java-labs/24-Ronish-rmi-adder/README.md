# Lab 24: Ronish rmi adder

## Source Code

### Adder.java

```java
import java.rmi.*;

public interface Adder extends Remote {
    public int add(int x, int y) throws RemoteException;
}
```

### App.java

```java
public class App {
    public static void main(String[] args) {
        System.out.println("Run MyServer first, then MyClient.");
    }
}
```

### MyClient.java

```java
import java.rmi.registry.*;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost", 5000);
        Adder adder = (Adder) reg.lookup("hiserver");
        int result = adder.add(20, 30);
        System.out.println("Sum = " + result);
    }
}
```

### MyServer.java

```java
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
```