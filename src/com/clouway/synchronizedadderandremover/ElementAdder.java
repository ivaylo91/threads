package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class ElementAdder extends Thread {
    private final SynchronizedList synchronizedList;
    private final String message;

    public ElementAdder(SynchronizedList synchronizedList, String message){
        this.synchronizedList = synchronizedList;
        this.message=message;
    }

    @Override
    public void run() {
        try{
            while (true){
                sleep(1000);
                synchronizedList.addElement(message);
            }
        }catch (InterruptedException inEx){
        }
    }
}
