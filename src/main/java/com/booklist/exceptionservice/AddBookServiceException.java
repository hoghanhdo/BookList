package com.booklist.exceptionservice;

public class AddBookServiceException extends  Exception{
    public AddBookServiceException() {
        super();
    }

    public AddBookServiceException(String message) {
        super(message);
    }

    public AddBookServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public AddBookServiceException(Throwable cause) {
        super(cause);
    }
}
