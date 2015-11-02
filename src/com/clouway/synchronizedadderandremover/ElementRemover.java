package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class ElementRemover extends Thread {
    private final SynchronizedList synchronizedList;

    public ElementRemover(SynchronizedList synchronizedList){
        this.synchronizedList = synchronizedList;
    }

    @Override
    public void run() {
        try{
            while(true){
                sleep(1000);
                synchronizedList.removeElement();
            }
        }catch (InterruptedException inEx){
            inEx.printStackTrace();
        }
    }
}
