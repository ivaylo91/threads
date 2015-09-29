package com.clouway.task4;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Producer extends Thread {
    private List list = new List(3);
    public final int max = 3;

    @Override
    public void run() {
        try {
            while (true) {
                putElement();
                sleep(2000);
            }
        } catch (InterruptedException e) {
        }
    }

    private synchronized void putElement() throws InterruptedException {
        while (list.size() == max) {
            wait();
        }
        list.add(new java.util.Date().toString());
        System.out.println("Put in list");
        notify();
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
