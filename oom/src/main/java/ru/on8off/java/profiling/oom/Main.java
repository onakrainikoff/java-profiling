package ru.on8off.java.profiling.oom;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(()-> new OOMExample(1_000_000, 0).startGeneration()).start();
        Thread.sleep(60*60* 1000);
    }
}
