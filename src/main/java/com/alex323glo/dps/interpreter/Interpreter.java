package com.alex323glo.dps.interpreter;

import com.alex323glo.dps.interpreter.exception.InterpreterException;
import com.alex323glo.dps.interpreter.model.state.State;
import com.alex323glo.dps.parser.exception.ParserException;

// TODO add doc
public interface Interpreter {

    // TODO fix logic of interpret()
    State interpret(State state, String commandsStr) throws ParserException, InterpreterException;

}
