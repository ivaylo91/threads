package com.clouway.task3;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        ThreadCounter thread1 = new ThreadCounter("Thread(1)",8);
        ThreadCounter thread2 = new ThreadCounter("Thread(2)",5);
        thread2.startCounting(thread1);

    }
}