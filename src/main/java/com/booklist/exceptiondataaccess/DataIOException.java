package com.booklist.exceptiondataaccess;

public class DataIOException extends Exception {
    public DataIOException() {
        super();
    }
    public DataIOException(String message) {
        super(message);
    }
    public DataIOException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataIOException(Throwable cause) {
        super(cause);
    }
}
