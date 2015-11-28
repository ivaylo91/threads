package multithreadcounter;

/**
 * Created by Ivaylo Penev(ipenev91@gmail.com)
 */
public class App {

    public static void main(String[] args) {

        Counter thread1 = new Counter("Thread-1", 1, 5);
        Counter thread2 = new Counter("Thread-2", 6, 10);

        thread1.start();
        thread2.start();

    }
}
