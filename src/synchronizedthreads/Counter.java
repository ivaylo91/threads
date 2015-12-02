package synchronizedthreads;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class Counter extends Thread {

    private int counter = 0;
    private final Object lock;

    public Counter(String name, Object lock) {
        super(name);
        this.lock = lock;
    }
    
    @Override
    public void run() {

        synchronized (lock) {

            for (int i = 1; i <=5; i++) {

                counter++;

                System.out.println(getName() + " -" + counter);

                lock.notify();

                try {
                    lock.wait();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}
