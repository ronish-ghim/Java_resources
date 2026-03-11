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
        Counter c = new Counter();
        Runnable a = () -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        };
        Runnable b = () -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Final count: " + c.count);
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
