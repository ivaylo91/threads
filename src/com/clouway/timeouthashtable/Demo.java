package com.clouway.timeouthashtable;

/**
 * Created by clouway on 15-11-11.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        TimeoutHashtable<String, String> timeoutHashtable = new TimeoutHashtable<>(5);
        timeoutHashtable.put("1", "edno");
        timeoutHashtable.put("2", "dve");
        timeoutHashtable.put("3", "tri");
        Thread.sleep(2000);
        timeoutHashtable.get("3");
        timeoutHashtable.put("2", "dve dve");
        Thread.sleep(2000);
        timeoutHashtable.get("3");
        timeoutHashtable.put("2", "dve dve dve");
        Thread.sleep(2000);
        timeoutHashtable.get("3");
        timeoutHashtable.put("2", "dve dve dve dve");
        timeoutHashtable.printElements();
    }
}
