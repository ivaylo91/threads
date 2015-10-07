package com.clouway.task5.timeouthastablelast;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class HashtableCleaner {
    final Object value;
    private final TimeoutRemover timeoutRemover;

    public HashtableCleaner(Object value, TimeoutRemover timeoutRemover) {
        this.value = value;
        this.timeoutRemover = timeoutRemover;
        timeoutRemover.start();
    }

    public void cancel() {
        timeoutRemover.interrupt();
    }
}
