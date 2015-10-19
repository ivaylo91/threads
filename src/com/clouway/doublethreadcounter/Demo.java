package com.clouway.doublethreadcounter;

/**
 * Created by clouway on 15-10-19.
 */
public class Demo {
    public static void main(String[] args) {
        DoubleThreadCounter firstDoubleThreadCounter = new DoubleThreadCounter("First Thread", 8);
        DoubleThreadCounter secondDoubleThreadCounter = new DoubleThreadCounter("Second Thread", 16);
        firstDoubleThreadCounter.start();
        secondDoubleThreadCounter.start();
        firstDoubleThreadCounter.setThread(secondDoubleThreadCounter);
        secondDoubleThreadCounter.setThread(firstDoubleThreadCounter);
    }
}
