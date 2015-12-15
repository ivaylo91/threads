package timeouthashtable;


import java.util.Map;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class TimeoutRemover<K, V> extends Thread {


    private Map<K, TimeoutRemover<K, V>> table;
    private K key;
    private V value;
    private long timeout;
    private int counter;


    public TimeoutRemover(Map<K, TimeoutRemover<K, V>> table, K key, V value, long timeout) {
        this.table = table;
        this.key = key;
        this.timeout = timeout;
        this.value = value;
    }

    @Override
    public void run() {
        while (counter < timeout) {
            try {
                Thread.sleep(1000);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (table.containsKey(key)) {
            table.remove(key);
        }
    }

    public Object getValue() {
        return value;
    }

    public void resetCounter() {
        this.counter = 0;
    }

}
