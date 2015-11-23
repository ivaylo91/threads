package multithreadcounter;

/**
 * Created by clouway on 11/20/15.
 */
public class App {

    public static void main(String[] args) {

        MultiThreadCounter multiThreadCounter1 = new MultiThreadCounter("Thread -1", 1, 5);
        MultiThreadCounter multiThreadCounter2 = new MultiThreadCounter("Thread -2", 6, 10);

        multiThreadCounter1.start();
        multiThreadCounter2.start();

    }
}
