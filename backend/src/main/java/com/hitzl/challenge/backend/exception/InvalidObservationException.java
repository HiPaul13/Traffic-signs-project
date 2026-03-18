package com.hitzl.challenge.backend.exception;

public class InvalidObservationException extends RuntimeException {
    public InvalidObservationException(String message) {
        super(message);
    }
}
