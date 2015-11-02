package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class ElementRemover extends Thread {
    private final ListOfElements listOfElements;

    public ElementRemover(ListOfElements listOfElements){
        this.listOfElements = listOfElements;
    }

    @Override
    public void run() {
        try{
            while(true){
                sleep(1000);
                listOfElements.removeElement();
            }
        }catch (InterruptedException inEx){
            inEx.printStackTrace();
        }
    }
}
