package com.clouway.task2;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread(1)",5);
        MyThread thread2 = new MyThread("Thread(2)",8);
        thread2.start();
        thread1.start();
        boolean thread1IsAlive = true;
        boolean thread2IsAlive = true;
        do {
            if (thread1IsAlive && !thread1.isAlive()) {
                thread1IsAlive = false;
                System.out.println("Thread 1 dead.");
                thread2.interrupt();
            }
            if (thread2IsAlive && !thread2.isAlive()) {
                thread2IsAlive = false;
                System.out.println("Thread 2 dead.");
                thread1.interrupt();
            }
        } while(thread1IsAlive && thread2IsAlive);
    }
}