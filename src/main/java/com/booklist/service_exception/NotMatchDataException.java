package com.booklist.service_exception;

public class NotMatchDataException extends Exception {

    public NotMatchDataException() {
        super();
    }

    public NotMatchDataException(String message) {
        super(message);
    }

    public NotMatchDataException(String message, Throwable cause) {
        super(message, cause);
    }
    public NotMatchDataException(Throwable cause) {
        super(cause);
    }
}

