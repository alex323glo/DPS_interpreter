package com.alex323glo.dps.interpreter;

import com.dima.dps.parser.Parser;
import com.dima.dps.parser.exceptions.ParserError;
import com.dima.dps.parser.parser_commands.ExecutionCommand;

import java.util.List;

// TODO add doc
public class InterpreterImpl implements Interpreter {

    private Parser parser;

    public InterpreterImpl(Parser parser) {
        this.parser = parser;
    }

    // TODO finish implementation: interpret(String)
    @Override
    public String interpret(String text) throws ParserError {

        List<ExecutionCommand> executionCommands = parser.parse(text);  // throws ParserError!

        return null;
    }
}
