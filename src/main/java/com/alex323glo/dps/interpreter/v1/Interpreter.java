package com.alex323glo.dps.interpreter.v1;

import com.alex323glo.dps.interpreter.exception.InterpreterException;
import com.alex323glo.dps.interpreter.model.state.State;
import com.dima.dps.parser.exceptions.ParserError;

// TODO add doc
public interface Interpreter {

    // TODO fix logic of interpret()
    State interpret(State state, String commandsStr) throws ParserError, InterpreterException;

}
