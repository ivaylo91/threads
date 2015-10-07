package com.clouway.task5.timeouthastablelast;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class TimeoutRemover extends Thread {
    private TimeoutHashtable table;
    private final String key;
    private long timeOut;

    public TimeoutRemover(TimeoutHashtable table, String key, long timeOut) {
        this.table = table;
        this.key = key;
        this.timeOut = timeOut;
    }
    @Override
    public void run() {
        try {
            this.sleep(timeOut);
        } catch (InterruptedException e) {

        }
        table.remove(key);

    }
}
