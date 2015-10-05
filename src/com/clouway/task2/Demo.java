package com.clouway.task2;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        ThreadCounter thread1 = new ThreadCounter("Thread(1)",8);
        ThreadCounter thread2 = new ThreadCounter("Thread(2)",5);
        thread2.setTarget(thread1);
        thread1.setTarget(thread2);
        thread1.start();
        thread2.start();
    }
}