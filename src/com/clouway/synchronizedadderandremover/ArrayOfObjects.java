package com.clouway.synchronizedadderandremover;

/**
 * Created by clouway on 15-11-2.
 */
public class ArrayOfObjects {
    private int index = 0;
    private Object[] objArray;
    private int size;

    public ArrayOfObjects(int size) {
        this.objArray = new Object[size];
        this.size = size;
    }

    public int getMaxSize() {
        return size;
    }

    public int getSize() {
        return index;
    }

    public void addElement(Object obj) throws ArrayIndexOutOfBoundsException {
        if (index < objArray.length) {
            objArray[index] = obj;
            index++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Size is bigger than array length");
        }
    }

    public void removeElement() {
        if (index != 0) {
            objArray[index - 1] = null;
            index--;
        }
    }

    public Object getLastMessage() {
        return objArray[index - 1];
    }
}
