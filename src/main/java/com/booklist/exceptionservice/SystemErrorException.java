package com.booklist.exceptionservice;

public class SystemErrorException extends Exception {
    public SystemErrorException() {
        super();
    }

    public SystemErrorException(String message) {
        super(message);
    }

    public SystemErrorException(String message, Throwable cause) {
        super(message, cause);
    }
    public SystemErrorException(Throwable cause) {
        super(cause);
    }

}
