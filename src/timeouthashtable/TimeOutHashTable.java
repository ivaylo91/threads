package timeouthashtable;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class TimeOutHashTable {

    private int counter;
    private long timeout;
    private Map<String, Object> timeoutHashtable = new Hashtable<>();
    TimeOutRemover thread;


    public TimeOutHashTable(long timeout) {
        this.timeout = timeout;
    }

    public void put(String key, Object obj) {
        if (!timeoutHashtable.containsKey(key)) {
            thread = new TimeOutRemover(timeout, key, timeoutHashtable);
            thread.start();
        }

        thread.reset();
        timeoutHashtable.put(key, obj);
        System.out.println("Size of hastable is :" + timeoutHashtable.size());
    }

    public String remove(String key) {
        if (!timeoutHashtable.containsKey(key)) {
            return null;
        }
        timeoutHashtable.remove(key);

        return "Remove -> Done";
    }

    public String get(String key) {

        if (!timeoutHashtable.containsKey(key)) {
            return null;
        }
        thread.reset();
        timeoutHashtable.get(key);

        return "Get -> Done";
    }
}
