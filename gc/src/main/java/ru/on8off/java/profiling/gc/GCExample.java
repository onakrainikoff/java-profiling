package ru.on8off.java.profiling.gc;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class GCExample {
    private int size;
    private int sleepMs;
    private List<String> list = new ArrayList<>();

    public GCExample(int size, int sleepMs) {
        this.size = size;
        this.sleepMs = sleepMs;
    }

    public void startGeneration(){
      try {
          long i = 0;
          while (true){
              System.out.println(">>> iteration: " + i);
              list.add(RandomStringUtils.random(size));
              i++;
              if(size != 0) {
                  Thread.sleep(sleepMs);
              }
          }
      } catch (Exception e){
          e.printStackTrace();
      }
    }

}
