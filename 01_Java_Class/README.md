# Module 01 — Java Core Programs

## Sub-programs

### 1. HelloWorld
**Path:** `01_HelloWorld/src/App.java`

```java
public class App {
    public static void main(String[] args) throws Exception {

        // taking input from user
        String name = System.console().readLine("Enter your name: ");
        int age = Integer.parseInt(System.console().readLine("Enter your age: "));
        System.out.println("Hello " + name + "!");
        if (age > 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }
    }

}
```

### 2. SimpleCalc
**Path:** `02_SimpleCalc/src/App.java`

```java
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\t\tCalculator Application");
        System.out.println("Enter two numbers to perform an operation:");

        int num1 = Integer.parseInt(System.console().readLine("Enter first number: "));
        int num2 = Integer.parseInt(System.console().readLine("Enter second number: "));

        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int choice = Integer.parseInt(System.console().readLine("Enter your choice (1-4): "));

        int result = 0;

        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case 4:
                if (num2 != 0) {
                    double divResult = (double) num1 / num2;
                    System.out.println("Result: " + divResult);
                } else {
                    // exception handling for division by zero
                    throw new ArithmeticException("Division by zero is not allowed.");

                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
```

### 3. IsPrime
**Path:** `03_IsPrime/src/App.java`

```java
public class App {
    public static void main(String[] args) throws Exception {
        int number = Integer.parseInt(System.console().readLine("Enter a positive integer: "));
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    static boolean isPrime(int number) {
        if (number <= 2)
            return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

### 4. ClassTypes
**Path:** `04_ClassTypes/src/App.java`

```java
public class App {

    public static void main(String[] args) {
        Nayan nay = new Nayan();
        nay.See();

        Nayan.Watch();
        System.out.println(Nayan.Mother);
    }
}

class Nayan {
    static String Mother = "Sab";

    void See() {
        System.out.println("Nayan Sees someone");
    }

    static void Watch() {
        System.out.println("Someone watches Nayan");
    }
}


// Exception handler Example
// NullPointerException
// divideByZeroException
// ClassNotFoundException
// FileNotFoundException
// IndexOutOfBoundsException
```

### 5. ArithmeticException
**Path:** `05_Exception/ArithmeticException/src/App.java`

```java
public class App {
    public static void main(String[] args) throws Exception {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException handled: " + e.getMessage());
        }
    }
}
```

### 6. ClassNotFoundException
**Path:** `05_Exception/ClassNotFoundException/src/App.java`

```java
public class App {
    public static void main(String[] args) throws Exception {
         try {
            Class.forName("com.example.UnknownClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException handled: " + e.getMessage());
        }
    }
}
```

### 7. FileNotFoundException
**Path:** `05_Exception/FileNotFoundException/src/App.java`

```java
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            FileInputStream file = new FileInputStream("abc.txt");
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException handled: " + e.getMessage());
        }
    }
}
```

### 8. IndexOutOfBoundsException
**Path:** `05_Exception/IndexOutOfBoundsException/src/App.java`

```java
public class App {
    public static void main(String[] args) {
        try {
            int arr[] = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException handled: " + e.getMessage());
        }
    }
}
```

### 9. NullPointerException
**Path:** `05_Exception/NullPointerException/src/App.java`

```java
public class App {
    public static void main(String[] args) throws Exception {
        try {
            String name = null;
            System.out.println(name.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled: " + e.getMessage());
        }

    }
}
```

### 10. SynchronizedBlock
**Path:** `06_Threads/SynchronizedBlock/src/App.java`

```java
public class App {
    public static void main(String[] args) throws Exception {
        Table t = new Table();
        Thread t1 = new MyThread1(t);
        Thread t2 = new MyThread2(t);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}

class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread1 extends Thread {
    Table t;

    MyThread1(Table t1) {
        this.t = t1;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t1) {
        this.t = t1;
    }

    @Override
    public void run() {
        t.printTable(100);
    }
}
```

### 11. Test_Concurrency
**Path:** `06_Threads/Test_Concurrency/src/App.java`

```java
public class App {
    public static void main(String[] args) throws Exception {
        // MyRunnable myRunnable = new MyRunnable();
        // Thread thread1 = new Thread(myRunnable);
        // thread1.start();

        // MyThread myThread1 = new MyThread();
        // MyThread myThread2 = new MyThread();
        // myThread1.setPriority(Thread.MAX_PRIORITY);
        // myThread2.setPriority(Thread.MIN_PRIORITY);
        // myThread1.start();
        // myThread2.start();
        // A a = new A();
        // B b = new B();
        // Counter c = new Counter();
        // Runnable a = () -> {
        // for (int i = 0; i < 1000; i++) {
        // c.increment();
        // }
        // };
        // Runnable b = () -> {
        // for (int i = 0; i < 1000; i++) {
        // c.increment();
        // }
        // };

        // Thread t1 = new Thread(a);
        // Thread t2 = new Thread(b);

        // t1.start();
        // t2.start();

        // t1.join();
        // t2.join();
        // System.out.println("Final count: " + c.count);

        new Test();
    }

}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName()
                + " ID: " + Thread.currentThread().threadId());
    }
}

class MyThread extends Thread {
    public void run() {
        // System.out.println("MyThread is running " + Thread.currentThread().getName()
        // + " ID: "
        // + threadId());
        System.out.println("Thread ID:" + threadId() + " Thread Priority:" + getPriority());
    }
}

class A implements Runnable {

    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class B implements Runnable {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

class Counter2 {
    static int count = 0;

    static void increment() {
        count++;
    }

    static void getCount() {
        System.out.println(count);
    }
}

class Test {
    Test() {
        Counter2.increment();
        Counter2.getCount();
        Counter2.increment();
        Counter2.increment();
        Counter2.getCount();
    }
}
```

### 12. ThreadPriority
**Path:** `06_Threads/ThreadPriority/src/App.java`

```java
public class App {
    public static void main(String[] args) throws Exception {

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("Thread ID: %d, Thread Priority: %d\n", this.threadId(), this.getPriority());
        }
    }
}
```

### 13. FileInputOutput
**Path:** `07_File/FileInputOutput/src/App.java`

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt");
            int c;
            while ((c = in.read()) != -1) {
                System.out.println(c);
                // out.write(c);
            }
            System.out.println("Contents copied Successfully.");
        } catch (Exception e) {
            throw e;
        }

        finally {
            in.close();
            out.close();
        }
    }
}
```

### 14. FilesSorter
**Path:** `07_File/FilesSorter/src/App.java`

```java
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
        String sourcePath = "./assets";
        String destinationPath = "./assets";
        File directory = new File(sourcePath);
        File[] files = directory.listFiles();
        Path htmlPath = Paths.get(destinationPath + "/html");
        Path cssPath = Paths.get(destinationPath + "/css");
        try {
            for (File file : files) {
                if (file.getName().endsWith(".html")) {

                    Files.copy(file.toPath(), htmlPath.resolve(file.getName()));
                } else if (file.getName().endsWith(".css")) {
                    Files.copy(file.toPath(), cssPath.resolve(file.getName()));

                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
```

### 15. InputClassification
**Path:** `07_File/InputClassification/src/App.java`

```java
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a string: ");
        String inputString = scanner.next();
        scanner.close();
        String lcStr = inputString.toLowerCase();
        String vowelString = "";
        String consonantString = "";
        for (int i = 0; i < inputString.length(); i++) {
            if (lcStr.charAt(i) == 'a' || lcStr.charAt(i) == 'e' || lcStr.charAt(i) == 'i' || lcStr.charAt(i) == 'o'
                    || lcStr.charAt(i) == 'u') {
                vowelString += inputString.charAt(i);
            } else {
                consonantString += inputString.charAt(i);
            }
        }

        try {
            FileWriter vowelWriter = new FileWriter("./Vowel.txt");
            vowelWriter.write(vowelString);
            vowelWriter.close();

            FileWriter consonantWriter = new FileWriter("./Consonant.txt");
            consonantWriter.write(consonantString);

            consonantWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
```

### 16. ListDir
**Path:** `07_File/ListDir/src/App.java`

```java
import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        String directoryPath = "C:\\Users\\Rons\\OneDrive\\Desktop\\Coding";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
```

### 17. Serialization
**Path:** `07_File/Serialization/src/App.java`

```java
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student();
        s1.address = "KTM";
        s1.name = "Ronce";
        s1.id = 101;

        try {
            FileOutputStream out = new FileOutputStream("input.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(s1);
            objOut.close();
            out.close();

            System.out.println("Object is Serialized");
            FileInputStream in = new FileInputStream("input.txt");
            ObjectInputStream obInput = new ObjectInputStream(in);
            s1 = (Student) obInput.readObject();
            in.close();
            obInput.close();

        } catch (Exception e) {
            e.getMessage();
        }

        System.out.println(s1.name + " " + s1.address + " " + s1.id);
    }
}

class Student implements Serializable {
    public String name;
    public String address;
    public int id;

}
```

### 18. VowelConsonantSeparation
**Path:** `07_File/VowelConsonantSeparation/src/App.java`

```java
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        File wordsFile = new File("words.txt");
        File vowelFile = new File("vowel.txt");
        File consonantFile = new File("consonant.txt");

        wordsFile.createNewFile();
        consonantFile.createNewFile();
        vowelFile.createNewFile();

        FileReader fr = new FileReader(wordsFile);
        FileWriter vfw = new FileWriter(vowelFile);
        FileWriter cfw = new FileWriter(consonantFile);

        BufferedReader br = new BufferedReader(fr);
        BufferedWriter vowelWriter = new BufferedWriter(vfw);
        BufferedWriter consonantWriter = new BufferedWriter(cfw);

        String word = "";

        int c;
        while ((c = br.read()) != -1) {
            if (c == '\n' || c == ' ') {
                System.out.println();
                continue;
            }

            System.out.printf("%c", c);

        }

        br.close();
        cfw.close();
        vfw.close();
    }
}
```
