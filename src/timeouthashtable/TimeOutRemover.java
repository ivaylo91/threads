package timeouthashtable;

import java.util.Map;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class TimeOutRemover extends Thread {


    private Map<String, Object> timeoutHashTable;
    private String key;
    private long timeout;
    private boolean reset;
    private long startTime = System.nanoTime();

    public TimeOutRemover(long timeout, String key, Map<String, Object> timeoutHashTable) {
        this.timeout = timeout;
        this.key = key;
        this.timeoutHashTable = timeoutHashTable;
    }

    @Override
    public void run() {
        for (int i = 0; i < timeout; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (reset) {
                reset = false;
                i = 0;
            }

            timeoutHashTable.remove(key);

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println(Thread.currentThread().getName() + "Time" + duration);

        }

    }

    public void reset() {

        reset = true;
    }


}
