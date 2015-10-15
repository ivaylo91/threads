package com.clouway.threadcounter;

/**
 * Created by clouway on 15-10-15.
 */
public class ThreadCounter extends Thread {

    public int i=0;
    public int stopTimeInSeconds;

    public ThreadCounter(int stopTimeInSeconds) {
        this.stopTimeInSeconds = stopTimeInSeconds;
    }

    public void run() {
        try {
            while (!interrupted() && i < stopTimeInSeconds) {
                sleep(1000);
                i++;
            }
        } catch (InterruptedException ie) {
            return;
        }
    }
}
