package addremovethreads;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class App {
    public static void main(String[] args) throws InterruptedException {

        ListOfElements listOfElements = new ListOfElements(new Object[5]);

        AddElement addElement = new AddElement(listOfElements, "Bai Tosho");

        RemoveElement removeElement = new RemoveElement(listOfElements, "Bai Tosho");

        addElement.start();

        Thread.sleep(50);

        removeElement.start();

        Thread.sleep(50);

        addElement.interrupt();

        removeElement.interrupt();
    }
}
