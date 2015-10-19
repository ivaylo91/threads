package com.clouway.doublethreadcounter;

/**
 * Created by clouway on 15-10-19.
 */
public class InterruptingThread extends Thread {
    private int counter = 0;
    private final int stopCounter;
    private InterruptingThread thread;
    private final String threadName;

    public InterruptingThread(String threadName, int stopCounter) {
        this.threadName = threadName;
        this.stopCounter = stopCounter;
    }

    public void run() {
        try {
            while (!interrupted() && counter < stopCounter) {
                sleep(500);
                counter++;
                System.out.println(threadName + " : " + counter);
            }
            thread.interrupt();
        } catch (InterruptedException inEx) {
            return;
        }
    }

    public void setThread(InterruptingThread thread) {
        this.thread = thread;
    }
}
