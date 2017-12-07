package com.alex323glo.dps.interpreter.exception;

/**
 * DPS Command execution exception class. Caused when Interpreter in some reasons
 * can't execute needed DPS commands on initial DPS (script) State during
 * interpretation process.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see com.alex323glo.dps.parser.model.command.Command
 * @see com.alex323glo.dps.interpreter.Interpreter
 */
public class ExecutionException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ExecutionException(String message) {
        super(message);
    }
}
