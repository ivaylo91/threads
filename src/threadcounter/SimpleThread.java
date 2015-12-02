package threadcounter;

/**
@author Ivaylo Penev(ipenev91@gmail.com)
 */
public class SimpleThread extends Thread {

    private int counter;

    @Override
    public void run() {

        if (isInterrupted()) {
            try {
                counter++;
                SimpleThread.sleep(100);
            } catch (InterruptedException e) {

                System.out.println(counter);
            }
        }
    }
}

