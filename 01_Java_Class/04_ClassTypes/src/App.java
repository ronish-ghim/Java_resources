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