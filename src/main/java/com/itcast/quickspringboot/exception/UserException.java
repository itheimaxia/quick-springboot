package com.itcast.quickspringboot.exception;

public class UserException extends Exception{
    private String message;
 
    public UserException(String msg)
    {
        this.message = msg;
    }
    public String getMessage() {
        return message;
    }
}