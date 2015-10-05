package com.clouway.task4;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        List list=new List(3);
        Producer producer = new Producer(list, "produser1");
        Producer producer1 = new Producer(list, "produser2");
        Remover remover=new Remover(list);
        remover.start();
        producer.start();
        producer1.start();

    }
}
