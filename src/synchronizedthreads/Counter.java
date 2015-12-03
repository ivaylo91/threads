package synchronizedthreads;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class Counter extends Thread {

    private final int start;
    private final int limit;
    private int counter = 0;
    private Object lock;


    public Counter(int start, int limit, Object lock) {

        this.start = start;
        this.lock = lock;
        this.limit = limit;
    }

    @Override
    public void run() {

        synchronized (lock) {

            for (int i = start; i <= limit; i++) {

                counter++;

                System.out.println(getName() + " -" + counter);

                lock.notify();

                if (counter == limit) {

                    break;
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

                Thread.interrupted();
            }
        }
    }
}
