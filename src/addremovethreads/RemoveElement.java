package addremovethreads;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class RemoveElement extends Thread {

    private ListOfElements listOfElements;
    private Object obj;

    public RemoveElement(ListOfElements listOfElements, Object obj) {
        this.listOfElements = listOfElements;
        this.obj = obj;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            System.out.println("Removed" + "->" + obj);
            listOfElements.remove();
        }
    }
}
