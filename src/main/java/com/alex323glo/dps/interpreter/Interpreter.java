package com.alex323glo.dps.interpreter;

import com.alex323glo.dps.interpreter.exception.InterpreterException;
import com.alex323glo.dps.interpreter.model.state.State;
import com.alex323glo.dps.parser.exception.ParserException;

/**
 * Interface for DPS Interpreter, which parses and executes DPS Commands
 * on DPS (script) State - crates new DPS State.
 *
 * @author alex323glo
 * @version 1.0.0
 */
public interface Interpreter {

    /**
     * Interprets (executes) DPS Commands on initial DPS State.
     *
     * @param state initial DPS (script) State.
     * @param commandsStr String representation of DPS Commands, which will be interpreted (executed).
     * @return new DPS (script) State, safe for old State (doesn't change old object and creates new one).
     * @throws ParserException when in some reasons can't parse DPS Commands (from String to
     * List of Command class objects).
     * @throws InterpreterException when in some reasons can't interpret (execute) parsed DPS Commands
     * on initial DPS (script) State.
     *
     * @see State
     * @see ParserException
     * @see InterpreterException
     */
    State interpret(State state, String commandsStr) throws ParserException, InterpreterException;

}
