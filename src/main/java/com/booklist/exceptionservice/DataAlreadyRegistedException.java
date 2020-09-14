package com.booklist.exceptionservice;

public class DataAlreadyRegistedException extends Exception {

    public DataAlreadyRegistedException() {
        super();
    }

    public DataAlreadyRegistedException(String message) {
        super(message);
    }

    public DataAlreadyRegistedException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataAlreadyRegistedException(Throwable cause) {
        super(cause);
    }

}
