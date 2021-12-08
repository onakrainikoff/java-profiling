package ru.on8off.java.profiling.deadlock;

public class Main {
    public static void main(String[] args) {
        var lock1 = new Object();
        var lock2 = new Object();
        new Thread(new DeadlockExample1(lock1, lock2)).start();
        new Thread(new DeadlockExample1(lock2, lock1)).start();
        new DeadlockExample2().doWorkExample2();
    }
}
