package com.example.demo.exception;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}
