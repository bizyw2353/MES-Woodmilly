package com.mes.exception;

public class FailServiceException extends RuntimeException{

    public FailServiceException(String message) {
        super(message);
    }
    public FailServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
