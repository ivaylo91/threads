package synchronizedthreads;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class Counter extends Thread {
    private int start;
    private int limit;
    private int counter = 0;
    private final Object lock;


    public Counter(int start, int limit, Object lock) {
        this.start = start;
        this.limit = limit;
        this.lock = lock;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            synchronized (lock) {

                for (int i = start; i <= limit; i++) {
                /*if (counter != limit) {*/

                    counter++;

                    System.out.println(getName() + " -" + counter);

                    lock.notify();
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
            Thread.interrupted();
        }
    }
}