package com.clouway.task4;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Remover extends Thread {
    Producer producer;

    Remover(Producer p) {
        producer = p;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = producer.getMessage();
                System.out.println("Got from list: " + message);
                sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
