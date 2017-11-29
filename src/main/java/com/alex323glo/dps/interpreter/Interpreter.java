package com.alex323glo.dps.interpreter;

import com.dima.dps.parser.exceptions.ParserError;

// TODO add doc
public interface Interpreter {

    // TODO fix logic of interpreter
    String interpret(String text) throws ParserError;

}
