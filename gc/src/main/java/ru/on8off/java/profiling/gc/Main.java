package ru.on8off.java.profiling.gc;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(()-> new GCExample(1_000_000, 50).startGeneration()).start();
        Thread.sleep(60*60* 1000);
    }
}
