package timeouthashtable;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        TimeoutHashTable<String, String> timeoutHashTable = new TimeoutHashTable<>(1000);

        timeoutHashTable.put("Bai Ivan", "Veliko Tarnovo");
        timeoutHashTable.put("4i4o Gosho", " Pernik");
        timeoutHashTable.put("Pesho", "Sofia");
        timeoutHashTable.put("Nikola", "General Toshevo");


        System.out.println(timeoutHashTable.get("Pesho"));
        timeoutHashTable.put("Nikola", "Pomorie");

        System.out.println(timeoutHashTable.get("4i4o Gosho"));
        timeoutHashTable.put("Bai Ivan", "Lovnidol");

        System.out.println(timeoutHashTable.get("Bai Ivan"));

    }
}