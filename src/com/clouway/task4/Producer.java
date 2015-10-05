package com.clouway.task4;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Producer extends Thread {
    private List list;
    public final int max = 3;
    private final String name;

    public Producer(List list, String name) {
        this.list = list;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(1000);
                putElement();
            }
        } catch (InterruptedException e) {
        }
    }

    private synchronized void putElement() throws InterruptedException {
        while (list.size() == max) {
            wait();
        }if (list.size() != max){
            list.add(name);
            System.out.println("Put in list --> "+list.getLast());
        }
        notify();
    }
}
