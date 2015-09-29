package com.clouway.task4;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        new Remover(producer).start();
    }
}
