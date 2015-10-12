package com.clouway.task5.timeouthastablelast;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class HashtableCleaner<T> {
    private T value;
    private final TimeoutRemover timeoutRemover;

    public HashtableCleaner(T value, TimeoutRemover timeoutRemover) {
        this.value = value;
        this.timeoutRemover = timeoutRemover;
        timeoutRemover.start();
    }

    public void setValue(T value){
        this.value=value;
    }

    public void restart(){
        timeoutRemover.setCounter(0);
    }

    public T getValue() {
        return value;
    }
}
