package com.example.demoaop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WebException extends RuntimeException{

    public WebException(String message) {
        super(message);
    }
    public WebException(String message, Throwable cause) {
        super(message, cause);
    }
}
