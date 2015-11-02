package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class Demo {
    public static void main(String[] args) {
        ArrayOfObjects arrayOfObjects = new ArrayOfObjects(8);
        ObjectAdder objectAdder = new ObjectAdder(arrayOfObjects,"Object A");
        ObjectAdder objectAdder2 = new ObjectAdder(arrayOfObjects,"Object B");
        ObjectRemover objectRemover = new ObjectRemover(arrayOfObjects);
        objectAdder.start();
        objectAdder2.start();
        objectRemover.start();
    }
}
