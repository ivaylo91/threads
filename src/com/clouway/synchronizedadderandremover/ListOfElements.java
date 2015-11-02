package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class ListOfElements {
    private int index = 0;
    private Object[] objArray;
    private int size;

    public ListOfElements(int size) {
        this.objArray = new Object[size];
        this.size = size;
    }

    public synchronized void addElement(String message) throws InterruptedException {
        while (index == size) {
            wait();
        }
        if (index < objArray.length) {
            objArray[index] = message;
            index++;
            System.out.println(objArray[index - 1] + " added!");
        }
        notify();
    }


    public synchronized void removeElement() throws InterruptedException {
        while (index == 0) {
            wait();
        }
        if (index == size) {
            objArray[index - 1] = null;
            index--;
            System.out.println(objArray[index - 1] + " removed!");
        }
        notify();
    }}
