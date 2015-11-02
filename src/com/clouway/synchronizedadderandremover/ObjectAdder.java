package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class ObjectAdder extends Thread {
    private final ArrayOfObjects arrayOfObjects;
    private final String message;

    public ObjectAdder(ArrayOfObjects arrayOfObjects, String message) {
        this.arrayOfObjects = arrayOfObjects;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(1000);
                addObject();
            }
        } catch (InterruptedException inEx) {
        }
    }

    private synchronized void addObject() throws InterruptedException {
        while (arrayOfObjects.getSize() == arrayOfObjects.getMaxSize()) {
            wait();
        }
        arrayOfObjects.addElement(message);
        System.out.println(arrayOfObjects.getLastMessage() + " added!");
        notify();
    }
}
