package multithreadcounter;

/**
 * Created by clouway on 11/20/15.
 */
public class MultiThreadCounter extends Thread {

    private int start;
    private int last;

    public MultiThreadCounter(String name, int start, int last) {
        super(name);
        this.start = start;
        this.last = last;
    }

    @Override
    public synchronized void run() {

        for (int i = start; i <= last; i++) {

            System.out.println(getName() + " - " + i);
        }
    }
}

