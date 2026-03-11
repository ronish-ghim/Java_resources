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