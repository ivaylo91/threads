package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class ElementAdder extends Thread {
    private final ListOfElements listOfElements;
    private final String message;

    public ElementAdder(ListOfElements listOfElements, String message){
        this.listOfElements = listOfElements;
        this.message=message;
    }

    @Override
    public void run() {
        try{
            while (true){
                sleep(1000);
                listOfElements.addElement(message);
            }
        }catch (InterruptedException inEx){
        }
    }
}
