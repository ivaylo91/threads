package com.clouway.task4;

/**
 * Created by clouway on 15-7-3.
 */
public class FullListException extends RuntimeException {
    private String message = "List is full";

    public FullListException() {
    }

    public FullListException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
