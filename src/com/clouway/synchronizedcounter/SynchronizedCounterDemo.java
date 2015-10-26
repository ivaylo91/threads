package com.clouway.synchronizedcounter;

/**
 * Created by clouway on 15-10-26.
 */
public class SynchronizedCounterDemo {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread firstCounter = new Thread(new SynchronizedCounter(30, lock));
        Thread secondCounter = new Thread(new SynchronizedCounter(30, lock));
        firstCounter.start();
        secondCounter.start();
    }
}
