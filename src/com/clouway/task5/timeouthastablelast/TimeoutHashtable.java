package com.clouway.task5.timeouthastablelast;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class TimeoutHashtable<K,V> {
    private Hashtable<K, TimeoutRemover> elementsTabel = new Hashtable<K, TimeoutRemover>();
    private TimeoutRemover<K,V> timeoutRemover;
    private final long timeOut;

    public TimeoutHashtable(long timeOut) {
        this.timeOut = timeOut;
    }

    public void put(K key, V value) {
        if (elementsTabel.containsKey(key)) {
            timeoutRemover.restart();
            elementsTabel.remove(key);
            timeoutRemover.setValue(value);
        }else {
            timeoutRemover = new TimeoutRemover<>(this, key,value, timeOut);
        }
        elementsTabel.put(key, timeoutRemover);
    }

    public V get(K key) {
        V object = null;
        if (elementsTabel.containsKey(key)) {
            timeoutRemover = elementsTabel.get(key);
            object = timeoutRemover.getValue();
            timeoutRemover.restart();
            elementsTabel.remove(key);
            elementsTabel.put(key, timeoutRemover);
        }
        return object;
    }

    public V remove(K key) {
        V object = null;
        if (elementsTabel.containsKey(key)) {
            timeoutRemover = elementsTabel.remove(key);
            object = timeoutRemover.getValue();
        }
        return object;
    }

    public void print() {
        if (!elementsTabel.isEmpty()) {
            Iterator it = elementsTabel.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                timeoutRemover = (TimeoutRemover) entry.getValue();
                System.out.println(entry.getKey() + " --> " + timeoutRemover.getValue());
            }
        } else {
            System.out.println("  ");
        }

    }
}
