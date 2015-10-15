package com.clouway.threadcounter;

/**
 * Created by clouway on 15-10-15.
 */
public class ThreadCounter extends Thread {

    public int startTimeInSeconds =0;
    public int stopTimeInSeconds;

    public ThreadCounter(int stopTimeInSeconds) {
        this.stopTimeInSeconds = stopTimeInSeconds;
    }

    public void run() {
        try {
            while (!interrupted() && startTimeInSeconds < stopTimeInSeconds) {
                sleep(1000);
                startTimeInSeconds++;
            }
        } catch (InterruptedException ie) {
            return;
        }
    }
}
