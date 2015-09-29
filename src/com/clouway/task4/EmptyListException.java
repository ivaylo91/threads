package com.clouway.task4;

/**
 * Created by clouway on 15-7-3.
 */
public class EmptyListException extends RuntimeException {
    private String message = "List is empty";

    public EmptyListException() {
    }

    public EmptyListException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
