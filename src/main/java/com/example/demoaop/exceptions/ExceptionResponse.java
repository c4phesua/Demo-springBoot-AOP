package com.example.demoaop.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private final Date timestamp;
    private final Integer status;
    private final String error;
    private final String path;

    public ExceptionResponse(Date timestamp, String error, String path, Integer status) {
        super();
        this.timestamp = timestamp;
        this.error = error;
        this.path = path;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public Integer getStatus() {
        return status;
    }
}