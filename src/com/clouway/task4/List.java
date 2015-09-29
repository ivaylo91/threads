package com.clouway.task4;

/**
 * Created by clouway on 15-6-4.
 */
public class List {
    private int index = 0;
    private Object[] list;

    public int size(){
        return index;
    }

    public List(int size) {

       list = new Object[size];
    }

    public void add(Object obj)throws FullListException{
        if (index < list.length) {
            list[index] = obj;
            this.index++;
        } else if (index >= list.length) {
            throw new FullListException("list size is " + list.length + " we can't to write more elements");
        }
    }

    public void remove()throws EmptyListException{
        if (index != 0) {
            list[index - 1] = null;
            index--;
        } else {
            throw new EmptyListException("List is empty can't remove");
        }
    }
    public Object getLast(){
        return list[index-1];
    }
    public void printAllElements() {
        for (int i = 0; i < this.index; i++) {
            System.out.println(list[i]);
        }
    }
}
