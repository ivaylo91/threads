package com.clouway.task3;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class ThreadCounter extends Thread {
    public  int counter;
    private final String name;
    public final int max;
    private ThreadCounter thread;

    public ThreadCounter(String name, int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()){
            try {
                count();
                System.out.println(name+" - "+ counter);
                if (this.counter ==this.max){
                    this.interrupt();
                    thread.interrupt();
                }
            } catch (InterruptedException e) {
                this.interrupt();
            }

        }
    }

    public void setTarget(ThreadCounter thread){
        this.thread = thread;
    }

    private synchronized void count() throws InterruptedException {
        while (counter == max) {
            wait();
        }
        counter++;
        notify();
    }
}