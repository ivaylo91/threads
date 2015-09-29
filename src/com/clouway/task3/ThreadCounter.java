package com.clouway.task3;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class ThreadCounter extends Thread {
    public  int counter;
    private final String name;
    public final int max;

    public ThreadCounter(String name, int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()){
            try {
                this.sleep(1000);
                counter++;
                System.out.println(name+"- "+ counter);
                if (this.counter ==this.max){
                    this.interrupt();
                }
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }

    public void startCounting(ThreadCounter thread){
        this.start();
        thread.start();
        boolean thread1IsAlive = true;
        boolean thread2IsAlive = true;
        do {
            if (thread1IsAlive && !thread.isAlive()) {
                thread1IsAlive = false;
                System.out.println("Thread 1 dead.");
                this.interrupt();
            }
            if (thread2IsAlive && !this.isAlive()) {
                thread2IsAlive = false;
                System.out.println("Thread 2 dead.");
                thread.interrupt();
            }
        } while(thread1IsAlive && thread2IsAlive);
    }
}