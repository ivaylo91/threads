package threadcounter;

/**
 * Created by clouway on 11/20/15.
 */
public class ThreadCounter extends Thread {

    private int counter;

    @Override
    public void run() {

        if (isInterrupted()) {
            try {
                counter++;
                ThreadCounter.sleep(100);
            } catch (InterruptedException e) {

                System.out.println(counter);
            }
        }
    }
}

