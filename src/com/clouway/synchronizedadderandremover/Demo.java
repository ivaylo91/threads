package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class Demo {
    public static void main(String[] args) {
        SynchronizedList synchronizedList = new SynchronizedList(8);
        ElementAdder elementAdder = new ElementAdder(synchronizedList,"Element A");
        ElementAdder elementAdder2 = new ElementAdder(synchronizedList,"Element B");
        ElementRemover elementRemover = new ElementRemover(synchronizedList);
        elementAdder.start();
        elementAdder2.start();
        elementRemover.start();
    }
}
