package threadcounter;

import java.util.Scanner;

/**
 * Created by clouway on 11/20/15.
 */
public class App {

    public static void main(String[] args) {

        SimpleThread threadCounter = new SimpleThread();

        Scanner input = new Scanner(System.in);

        input.next();

        threadCounter.start();

        threadCounter.interrupt();
    }
}
