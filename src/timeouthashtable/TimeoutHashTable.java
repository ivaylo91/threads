package timeouthashtable;

import sun.jvm.hotspot.jdi.ThreadReferenceImpl;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class TimeoutHashTable<String, Object> {

    private Map<String, TimeoutRemover<String, Object>> timeoutHashTable = new Hashtable<>();
    private long timeout;
    private TimeoutRemover<String, Object> thread;

    public TimeoutHashTable(long timeout) {
        this.timeout = timeout;
    }

    public void put(String key, Object value) {
        thread = new TimeoutRemover<>(timeoutHashTable, key, value, timeout);
        timeoutHashTable.put(key, thread);
        thread.start();
    }

    public Object get(String key) {
        if (!timeoutHashTable.containsKey(key)) {
            return null;
        } else {
            thread.resetCounter();
            return timeoutHashTable.get(key).getValue();
        }
    }

    public Object remove(String key) {
        if (!timeoutHashTable.containsKey(key)) {
            return null;
        }
        return timeoutHashTable.remove(key).getValue();

    }

    public void printAllElements() {

        Iterator it = timeoutHashTable.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();

            TimeoutRemover timeoutRemover = (TimeoutRemover) pair.getValue();
            System.out.println(pair.getKey() + " --> " + timeoutRemover.getValue());

        }
    }

}
