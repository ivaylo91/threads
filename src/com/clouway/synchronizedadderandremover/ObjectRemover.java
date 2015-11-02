package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class ObjectRemover extends Thread {
    private final ArrayOfObjects arrayOfObjects;

    public ObjectRemover(ArrayOfObjects arrayOfObjects) {
        this.arrayOfObjects = arrayOfObjects;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(1000);
                removeObject();
            }
        } catch (InterruptedException inEx) {
            inEx.printStackTrace();
        }
    }

    public synchronized void removeObject() throws InterruptedException {
        while (arrayOfObjects.getSize() == 0) {
            wait();
        }
        if (arrayOfObjects.getSize() == arrayOfObjects.getMaxSize()) {
            arrayOfObjects.removeElement();
            System.out.println(arrayOfObjects.getLastMessage() + " removed!");
        }
        notify();
    }
}
