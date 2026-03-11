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