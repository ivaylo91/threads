package com.clouway.threadcounter;

import java.util.Scanner;

/**
 * Created by clouway on 15-10-15.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ThreadCounter threadCounter = new ThreadCounter(20);
        threadCounter.start();
        Scanner input = new Scanner(System.in);
        System.out.println("Press any key:");
        if (input.hasNext()) {
            threadCounter.interrupt();
        }
        System.out.println("Thread interrupted at: "+threadCounter.secondsPassed +" second.");
    }
}
