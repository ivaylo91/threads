package multithreadcounter;

/**
 *
 * @author Ivaylo Penev(ipenev91@gmail.com)
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
