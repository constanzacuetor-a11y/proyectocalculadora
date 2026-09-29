package com.example.Calculadora.exception;

public class OperacionInvalidaException extends RuntimeException {
    public OperacionInvalidaException(String message) {
        super(message);
    }
}
