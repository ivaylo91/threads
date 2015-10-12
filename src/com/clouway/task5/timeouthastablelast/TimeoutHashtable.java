package com.clouway.task5.timeouthastablelast;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class TimeoutHashtable<K,V> {
    private Hashtable<K, TimeoutRemover<K,V>> elementsTabel = new Hashtable<>();
    private final long timeOut;

    public TimeoutHashtable(long timeOut) {
        this.timeOut = timeOut;
    }

    public void put(K key, V value) {
        if (elementsTabel.containsKey(key)) {
            TimeoutRemover<K,V> timeoutRemover=elementsTabel.get(key);
            timeoutRemover.restart();
            timeoutRemover.setValue(value);
        }else {
            TimeoutRemover<K, V> remover = new TimeoutRemover<>(this, key, value, timeOut);
            remover.start();
            elementsTabel.put(key, remover);
        }
    }

    public V get(K key) {
        V object = null;
        if (elementsTabel.containsKey(key)) {
            TimeoutRemover<K,V> timeoutRemover=elementsTabel.get(key);
            timeoutRemover = elementsTabel.get(key);
            object = timeoutRemover.getValue();
            timeoutRemover.restart();
        }
        return object;
    }

    public V remove(K key) {
        V object = null;
        if (elementsTabel.containsKey(key)) {
            TimeoutRemover<K,V> timeoutRemover=elementsTabel.get(key);
            timeoutRemover =elementsTabel.remove(key);
            object = timeoutRemover.getValue();
        }
        return object;
    }

    public void print() {
        if (!elementsTabel.isEmpty()) {
            Iterator it = elementsTabel.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                TimeoutRemover timeoutRemover = (TimeoutRemover) entry.getValue();
                System.out.println(entry.getKey() + " --> " + timeoutRemover.getValue());
            }
        } else {
            System.out.println("  ");
        }
    }
}
