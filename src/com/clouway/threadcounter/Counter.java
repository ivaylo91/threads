package com.clouway.threadcounter;

/**
 * Created by clouway on 15-10-15.
 */
public class Counter extends Thread {

    public int secondsPassed =0;
    public int stopTimeInSeconds;

    public Counter(int stopTimeInSeconds) {
        this.stopTimeInSeconds = stopTimeInSeconds;
    }

    public void run() {
        try {
            while (!interrupted() && secondsPassed < stopTimeInSeconds) {
                sleep(1000);
                secondsPassed++;
            }
        } catch (InterruptedException ie) {
            return;
        }
    }
}
