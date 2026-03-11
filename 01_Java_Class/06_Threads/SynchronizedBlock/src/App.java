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