package threadcounter;

import java.util.Scanner;

/**
 * Created by Ivaylo Penev(ipenev91@gmail.com)
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
