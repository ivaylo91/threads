package com.clouway.task2;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class ThreadCounter extends Thread {
    public int counter;
    private final String name;
    public final int max;
    private ThreadCounter thread;

    public ThreadCounter(String name, int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                sleep((long) (3000 * Math.random()));
                counter++;
                System.out.println(name + "- " + counter);
                if (this.counter == this.max) {
                    interrupt();
                    thread.interrupt();
                }
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }

    public void setTarget(ThreadCounter thread) {
        this.thread = thread;
    }
}