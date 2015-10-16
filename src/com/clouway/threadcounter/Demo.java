package com.clouway.threadcounter;

import java.util.Scanner;

/**
 * Created by clouway on 15-10-15.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(20);
        counter.start();
        Scanner input = new Scanner(System.in);
        System.out.println("Press any key:");
        if (input.hasNext()) {
            counter.interrupt();
        }
        System.out.println("Thread interrupted at: "+ counter.secondsPassed +" second.");
    }
}
