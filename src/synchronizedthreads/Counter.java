package synchronizedthreads;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class Counter extends Thread {

    private final Object counter;
    private int limit;

    public Counter(String name, int limit, Object counter) {
        super(name);
        this.limit = limit;
        this.counter = counter;
    }

    @Override
    public void run() {

        synchronized (counter) {

            for (int i = 1; i <= limit; i++) {
                
                System.out.println(getName() + " -" + i);
                counter.notify();
                
                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
