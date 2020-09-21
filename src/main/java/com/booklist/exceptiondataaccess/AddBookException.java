package com.booklist.exceptiondataaccess;

public class AddBookException extends Exception {
    public AddBookException() {
        super();
    }
    public AddBookException(String message) {
        super(message);
    }
    public AddBookException(String message, Throwable cause) {
        super(message, cause);
    }
    public AddBookException(Throwable cause) {
        super(cause);
    }
}
