package addremovethreads;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class ListOfElements {

    private Object[] array;
    private int index = 0;

    /**
     * Constructor
     */
    public ListOfElements(Object[] arr) {
        array = arr;
    }

    /**
     * Adding new elements in list
     *
     * @param obj is a parameter which we add
     */
    public synchronized void add(Object obj) {
        while (index >= array.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        array[index] = obj;
        index++;
        notify();
    }

    /**
     * Remove elemets from list
     */

    public synchronized void remove() {

        while (array[0] == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index--;
        array[index] = null;
        notify();
    }

   /* public synchronized void printAllElements() {
        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + " ");
        }
    }*/
}
