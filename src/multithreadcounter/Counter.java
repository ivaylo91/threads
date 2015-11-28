package multithreadcounter;

/**
 * Created by Ivaylo Penev(ipenev91@gmail.com)
 */
public class Counter extends Thread {

    private String name;
    private int start;
    private int last;

    public Counter(String name, int start, int last) {
        this.name = name;
        this.start = start;
        this.last = last;
    }

    @Override
    public void run() {

        for (int i = start; i <= last; i++) {

            System.out.println(name + "-" + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }
}

