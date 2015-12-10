package addremovethreads;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class AddElement extends Thread {

    private ListOfElements listOfElements;
    private Object obj;

    public AddElement(ListOfElements listOfElements, Object obj) {
        this.listOfElements = listOfElements;
        this.obj = obj;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            System.out.println("Add" + "->" + obj);
            listOfElements.add(obj);

        }
    }
}
