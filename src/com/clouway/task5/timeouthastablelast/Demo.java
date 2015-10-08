package com.clouway.task5.timeouthastablelast;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        TimeoutHashtable hashtable=new TimeoutHashtable(1000);

        hashtable.put("slavi","slavi");
        hashtable.put("gosho","gosho");
        Thread.sleep(300);
        hashtable.print();
        System.out.println();
        hashtable.put("nikola", "nikola");
        System.out.println(hashtable.get("gosho"));
        System.out.println();
        Thread.sleep(300);
        hashtable.put("gosho", "gosho1");
        hashtable.put("ivan", "ivan");
        hashtable.print();
        hashtable.remove("nikola");
        System.out.println();
        Thread.sleep(600);
        hashtable.print();
        System.out.println();
        Thread.sleep(300);
        hashtable.print();
        System.out.println();
    }

}
