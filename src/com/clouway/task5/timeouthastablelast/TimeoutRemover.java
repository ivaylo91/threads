package com.clouway.task5.timeouthastablelast;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class TimeoutRemover<K,V> extends Thread {
    private TimeoutHashtable<K,V> table;
    private final K key;
    private V value;
    private long timeOut;
    private long counter;

    public TimeoutRemover(TimeoutHashtable table, K key,V value, long timeOut) {
        this.table = table;
        this.key = key;
        this.value = value;
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
            table.remove(key);
        }
    }
    public void setValue(V value){
        this.value=value;
    }

    public void restart(){
       this.counter=0;
    }

    public V getValue() {
        return value;
    }
}
