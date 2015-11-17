package com.clouway.timeouthashtable;

/**
 * Created by clouway on 15-11-11.
 */
public class EntryExisting<K, V> extends Thread {
    private TimeoutHashtable timeoutHashtable;
    private long counter;
    private long timeout;
    private K key;
    private V value;

    public EntryExisting(TimeoutHashtable timeoutHashtable, K key, V value, long timeout) {
        this.timeoutHashtable = timeoutHashtable;
        this.key = key;
        this.value = value;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            while (counter < timeout) {
                sleep(1000);
                counter++;
            }
            System.out.println(timeoutHashtable.remove(key) + " deleted.");
        } catch (InterruptedException inEx) {
            inEx.printStackTrace();
        }
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void restartCounter() {
        this.counter = 0;
    }
}
