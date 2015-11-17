package com.clouway.timeouthashtable;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by clouway on 15-11-11.
 */
public class TimeoutHashtable<K, V> {
    Map<K, EntryExisting<K, V>> table = new Hashtable<>();
    private long timeout;

    public TimeoutHashtable(long timeout) {
        this.timeout = timeout;
    }

    public void put(K key, V value) {
        if (!table.containsKey(key)) {
            EntryExisting<K, V> remover = new EntryExisting<>(this, key, value, timeout);
            table.put(key, remover);
            remover.start();
        } else {
            EntryExisting<K, V> remover = table.get(key);
            remover.setValue(value);
            remover.restartCounter();
        }
    }

    public V get(K key) {
        if (table.containsKey(key)) {
            EntryExisting<K, V> remover = table.get(key);
            remover.restartCounter();
            return remover.getValue();
        } else {
            return null;
        }
    }

    public V remove(K key) {
        if (table.containsKey(key)) {
            EntryExisting<K, V> remover = table.remove(key);
            return remover.getValue();
        } else {
            return null;
        }
    }

    public void printElements() {
        for (Map.Entry<K, EntryExisting<K, V>> entry : table.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getValue());
        }
    }
}