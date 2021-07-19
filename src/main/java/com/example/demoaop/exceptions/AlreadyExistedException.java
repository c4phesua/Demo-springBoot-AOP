package com.example.demoaop.exceptions;
public class AlreadyExistedException extends RuntimeException {
    public AlreadyExistedException(String exception) {
        super(exception);
    }
}