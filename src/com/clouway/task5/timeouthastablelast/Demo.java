package com.clouway.task5.timeouthastablelast;

import java.util.Date;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        TimeoutHashtable hashtable=new TimeoutHashtable(1000);

        hashtable.put("slavi",new Date());
        hashtable.put("gosho",new Date());
        Thread.sleep(300);
        hashtable.print();
        System.out.println();
        hashtable.put("nikola", new Date());
        System.out.println(hashtable.get("gosho"));
        System.out.println();
        Thread.sleep(300);
        hashtable.put("gosho", new Date());
        hashtable.put("ivan", new Date());
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
