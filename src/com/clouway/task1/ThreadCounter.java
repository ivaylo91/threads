package com.clouway.task1;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class ThreadCounter extends Thread {
    private int counter;

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                sleep(1000);
                counter++;
            } catch (InterruptedException e) {
                 System.out.println(counter);
            }

        }
    }
}
