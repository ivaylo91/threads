package multithreadcounter;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com).
 **/
public class App {

    public static void main(String[] args) {

        Counter t1 = new Counter("Thread-1", 1, 5);
        Counter t2 = new Counter("Thread-2", 6, 10);

        t1.start();
        t2.start();

    }
}
