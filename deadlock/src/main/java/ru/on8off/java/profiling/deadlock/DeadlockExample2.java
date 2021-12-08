package ru.on8off.java.profiling.deadlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class DeadlockExample2 {

    public synchronized void doWorkExample2(){
        System.out.println(Thread.currentThread().getName() + "start doWorkExample2()");
        var executor = Executors.newSingleThreadExecutor();
        var future = executor.submit(this::doWorkExample2);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
