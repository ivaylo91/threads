package com.clouway.task5.timeouthastablelast;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class TimeoutHashtable<K,V> {
    private Hashtable<K, HashtableCleaner> elementsTabel = new Hashtable<K, HashtableCleaner>();
    private HashtableCleaner<V> hashtableCleaner;
    private final long timeOut;

    public TimeoutHashtable(long timeOut) {
        this.timeOut = timeOut;
    }

    public void put(K key, V value) {
        if (elementsTabel.containsKey(key)) {
            hashtableCleaner.restart();
            elementsTabel.remove(key);
            hashtableCleaner.setValue(value);
        }else {
            hashtableCleaner = new HashtableCleaner(value, new TimeoutRemover<K>(this, key, timeOut));
        }
        elementsTabel.put(key, hashtableCleaner);
    }

    public V get(K key) {
        V object = null;
        if (elementsTabel.containsKey(key)) {
            hashtableCleaner = (HashtableCleaner) elementsTabel.get(key);
            object = hashtableCleaner.getValue();
            hashtableCleaner.restart();
            elementsTabel.remove(key);
            elementsTabel.put(key, hashtableCleaner);
        }
        return object;
    }

    public V remove(K key) {
        V object = null;
        if (elementsTabel.containsKey(key)) {
            hashtableCleaner = (HashtableCleaner) elementsTabel.remove(key);
            object = hashtableCleaner.getValue();
        }
        return object;
    }

    public void print() {
        if (!elementsTabel.isEmpty()) {
            Iterator it = elementsTabel.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                hashtableCleaner = (HashtableCleaner) entry.getValue();
                System.out.println(entry.getKey() + " --> " + hashtableCleaner.getValue());
            }
        } else {
            System.out.println("  ");
        }

    }
}
