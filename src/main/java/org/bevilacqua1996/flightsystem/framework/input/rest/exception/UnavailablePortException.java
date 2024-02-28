package org.bevilacqua1996.flightsystem.framework.input.rest.exception;

public class UnavailablePortException extends RuntimeException {
    public UnavailablePortException() {
        super("Unavailable Port for this context");
    }

    public UnavailablePortException(String message) {
        super("Unavailable Port for this context: " + message);
    }
}
