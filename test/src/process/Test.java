package process;

public class Test {
    public static void main(String[] args) {
        MyThread th1 = new MyThread("*");
        MyThread th2 = new MyThread("**");
        MyThread th3 = new MyThread("***");

        th1.start();
        th2.start();
        th3.start();

        MyThread.delay(2000);
        th1.suspend();
        MyThread.delay(2000);
        th2.suspend();
        MyThread.delay(3000);
        th1.resume();
        MyThread.delay(3000);
        th1.stop();
        th2.stop();
        MyThread.delay(2000);
        th3.stop();
    }
}

class MyThread implements Runnable {
    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread th;

    MyThread(String name) {
        this.th = new Thread(this, name);
    }

    void start() {
        th.start();
    }

    void stop() {
        stopped = true;
    }

    void suspend() {
        suspended = true;
    }

    void resume() {
        suspended = false;
    }

    public static void delay(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void run() {
        while (!stopped) {
            if (!suspended) {
                System.out.println(Thread.currentThread().getName());
                delay(1000);
            }
        }
    }
}
