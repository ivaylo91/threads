package synchronizedthreads;

/**
 * Created by clouway on 01.12.15.
 */
public class App {

    public static void main(String[] args) {

        Object counter = new Object();

        Counter thread1 = new Counter("Thread-1", 5, counter);
        Counter thread2 = new Counter("Thread-2", 5, counter);

        thread1.start();
        thread2.start();
    }

}