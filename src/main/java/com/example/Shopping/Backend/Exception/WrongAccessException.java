package com.example.Shopping.Backend.Exception;

public class WrongAccessException extends RuntimeException{
    public WrongAccessException(String msg){
        super(msg);
    }
}
