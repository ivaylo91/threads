package multithreadcounter;

/**
 *
 * Created by clouway on 11/25/15.
 */
public class Counter extends Thread {

    private int start;
    private int end;

    public Counter(String threadname, int start, int end) {

        super(threadname);
        this.start = start;
        this.end = end;

    }

    @Override
    public void run() {

        try {
            for (int i = start; i <= end; i++) {

                System.out.println(getName() + "-" + i);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
