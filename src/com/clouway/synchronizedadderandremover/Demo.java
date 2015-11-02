package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class Demo {
    public static void main(String[] args) {
        ListOfElements listOfElements = new ListOfElements(8);
        ElementAdder elementAdder = new ElementAdder(listOfElements,"Element A");
        ElementAdder elementAdder2 = new ElementAdder(listOfElements,"Element B");
        ElementRemover elementRemover = new ElementRemover(listOfElements);
        elementAdder.start();
        elementAdder2.start();
        elementRemover.start();
    }
}
