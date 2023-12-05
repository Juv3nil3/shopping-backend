package com.example.Shopping.Backend.Exception;

public class WrongCredentialException extends RuntimeException{
    public WrongCredentialException(String msg) {
        super(msg);
    }
}
