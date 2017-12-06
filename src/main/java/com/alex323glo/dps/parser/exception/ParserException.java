package com.alex323glo.dps.parser.exception;

/**
 * DPS Parser execution exception class. Caused when CommandParser in some reasons
 * can't parse needed DPS commands.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see com.alex323glo.dps.parser.CommandParser
 */
public class ParserException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ParserException(String message) {
        super(message);
    }
}
