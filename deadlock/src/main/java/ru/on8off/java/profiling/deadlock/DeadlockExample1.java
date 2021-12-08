package ru.on8off.java.profiling.deadlock;

public class DeadlockExample1 implements Runnable{
    private final Object lock1;
    private final Object lock2;

    public DeadlockExample1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName() + " got lock1: " + lock1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + " got lock2: " + lock2);
            }
        }
    }
}
