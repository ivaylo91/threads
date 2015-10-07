package com.clouway.task5.timeouthastablelast;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class TimeoutHashtable {
    private Hashtable<String, Object> elementsTabel = new Hashtable<String, Object>();
    private HashtableCleaner hashtableCleaner;
    private final long timeOut;

    public TimeoutHashtable(long timeOut) {
        this.timeOut = timeOut;
    }

    public void put(String key, Object value) {
        hashtableCleaner = new HashtableCleaner(value, new TimeoutRemover(this, key, timeOut));
        elementsTabel.put(key, hashtableCleaner);
    }

    public Object get(String key) {
        Object object = null;
        if (elementsTabel.containsKey(key)) {
            hashtableCleaner = (HashtableCleaner) elementsTabel.get(key);
            object = hashtableCleaner.value;
            hashtableCleaner.cancel();
            elementsTabel.remove(key);
            hashtableCleaner = new HashtableCleaner(hashtableCleaner.value, new TimeoutRemover(this, key, timeOut));
            elementsTabel.put(key, hashtableCleaner);
        }
        return object;
    }

    public Object remove(String key) {
        Object object = null;
        if (elementsTabel.containsKey(key)) {
            hashtableCleaner = (HashtableCleaner) elementsTabel.remove(key);
            object = hashtableCleaner.value;
            hashtableCleaner.cancel();
        }
        return object;
    }

    public void print() {
        if (!elementsTabel.isEmpty()) {
            Iterator it = elementsTabel.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                hashtableCleaner = (HashtableCleaner) entry.getValue();
                System.out.println(entry.getKey() + " --> " + hashtableCleaner.value);
            }
        } else {
            System.out.println("  ");
        }

    }
}
