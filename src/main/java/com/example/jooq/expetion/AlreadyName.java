package com.example.jooq.expetion;

public class AlreadyName extends RuntimeException{
    public AlreadyName(String message) {
        super(message);
    }
}