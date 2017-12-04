package com.alex323glo.dps.interpreter.exception;

/**
 * Created by alex323glo on 30.11.17.
 */
public class InterpreterException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public InterpreterException(String message) {
        super(message);
    }
}
