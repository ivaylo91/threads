package com.clouway.synchronizedcounter;

/**
 * Created by clouway on 15-10-26.
 */
public class SynchronizedCounter implements Runnable {
    private final int stopCounter;
    private final Object lock;
    private int counter = 0;

    public SynchronizedCounter(int stopCounter, Object lock) {
        this.stopCounter = stopCounter;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (counter < stopCounter) {
                counter++;
                System.out.println(Thread.currentThread().getName() + " : " + counter);
                lock.notify();
                if (counter == stopCounter) {
                    break;
                }
                try {
                    lock.wait();
                } catch (InterruptedException inEx) {
                    inEx.printStackTrace();
                }
            }
        }
    }
}

