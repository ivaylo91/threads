package com.clouway.task2;

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
                this.sleep((long)(3000*Math.random()));
                counter++;
                System.out.println(name+"- "+ counter);
                if (this.counter ==this.max){
                    this.interrupt();
                    thread.interrupt();
                }
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }

    public void startCounting(ThreadCounter thread){
        this.thread = thread;
        if (!thread.isAlive()&&!this.isAlive()){
            this.start();
            thread.start();
        }
    }
}