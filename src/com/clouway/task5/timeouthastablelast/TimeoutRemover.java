package com.clouway.task5.timeouthastablelast;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class TimeoutRemover<K> extends Thread {
    private TimeoutHashtable table;
    private final K key;
    private long timeOut;
    private long counter;

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public TimeoutRemover(TimeoutHashtable table, K key, long timeOut) {
        this.table = table;
        this.key = key;
        this.timeOut = timeOut;
    }

    @Override
    public void run() {
        try {
            while (counter<timeOut){
                sleep(1);
                counter++;
            }
            table.remove(key);
        } catch (InterruptedException e) {

        }
    }
}
