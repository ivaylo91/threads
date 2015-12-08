package synchronizedthreads;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com).
 */
public class App {

    public static void main(String[] args) {

        Object lock = new Object();

        Counter thread1 = new Counter(1, 5, lock);
        Counter thread2 = new Counter(1, 5, lock);

        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        thread1.start();
        thread2.start();


    }
}
