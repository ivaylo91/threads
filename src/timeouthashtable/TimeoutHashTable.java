package timeouthashtable;

import java.util.Hashtable;
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
    }

    public Object get(String key) {
        if (!timeoutHashTable.containsKey(key)) {
            return null;
        } else {
            return timeoutHashTable.get(key).getValue();
        }
    }

    public Object remove(String key) {
        if (timeoutHashTable.containsKey(key)) {
            return null;
        }
        return timeoutHashTable.remove(key).getValue();
    }
}
