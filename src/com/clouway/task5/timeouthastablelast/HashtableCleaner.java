package com.clouway.task5.timeouthastablelast;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class HashtableCleaner {
    private Object value;
    private final TimeoutRemover timeoutRemover;

    public HashtableCleaner(Object value, TimeoutRemover timeoutRemover) {
        this.value = value;
        this.timeoutRemover = timeoutRemover;
        timeoutRemover.start();
    }

    public void setValue(Object value){
        this.value=value;
    }

    public void restart(){
        timeoutRemover.counter=0;
    }

    public Object getValue() {
        return value;
    }
}
