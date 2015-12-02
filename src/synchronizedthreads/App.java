package synchronizedthreads;

/**
 * @author  Ivaylo Penev(ipenev91@gmail.com).
 */
public class App {

    public static void main(String[] args) {

        Object lock = new Object();

        Counter thread1 = new Counter("Thread-1",lock);
        Counter thread2 = new Counter("Thread-2",lock);

        thread1.start();
        thread2.start();
    }

}
