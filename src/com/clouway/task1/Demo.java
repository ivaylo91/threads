package com.clouway.task1;

import java.util.Scanner;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        MyThreads mt=new MyThreads();
        mt.start();
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            mt.interrupt();
        }
    }
}
