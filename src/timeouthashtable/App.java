package timeouthashtable;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class App {

    public static void main(String[] args) {

        TimeOutHashTable timeOutHashTable = new TimeOutHashTable(3);

        Person person = new Person();

        Person person1 = new Person();

        timeOutHashTable.put("John", person);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timeOutHashTable.put("John", person1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(timeOutHashTable.get("John"));
    }
}
