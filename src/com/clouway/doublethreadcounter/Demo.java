package com.clouway.doublethreadcounter;

/**
 * Created by clouway on 15-10-19.
 */
public class Demo {
    public static void main(String[] args) {
        InterruptingThread firstInterruptingThread = new InterruptingThread("First Thread", 8);
        InterruptingThread secondInterruptingThread = new InterruptingThread("Second Thread", 16);
        firstInterruptingThread.setThread(secondInterruptingThread);
        secondInterruptingThread.setThread(firstInterruptingThread);
        firstInterruptingThread.start();
        secondInterruptingThread.start();

    }
}
