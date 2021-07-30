package com.coma.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionModel {

    private final String message;
    private final LocalDateTime timeStamp;
    private final HttpStatus httpStatus;
    

    public ExceptionModel(String message, LocalDateTime timeStamp, HttpStatus httpStatus) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.httpStatus = httpStatus;
    }


    public String getMessage() {
        return this.message;
    }


    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }


    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

   
    
}
