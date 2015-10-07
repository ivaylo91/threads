package com.clouway.task4;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public final class Remover extends Thread {
    private final List list;

    public Remover(List list) {
        this.list = list;
    }

    @Override
    public void run() {

        try {
            while (true) {
                sleep(1000);
                System.out.println("Got from list: " + getMessage());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getMessage() throws InterruptedException {
        while (list.size() == 0) {
            wait();
        }
        String message = (String) list.getLast();
        list.remove();
        notify();
        return message;
    }
}
