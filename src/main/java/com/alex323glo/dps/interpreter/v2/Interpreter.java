package com.alex323glo.dps.interpreter.v2;

import com.alex323glo.dps.interpreter.exception.InterpreterException;
import com.dima.dps.parser.Parser;
import com.dima.dps.parser.exceptions.ParserError;
import com.dima.dps.parser.parser_commands.ExecutionCommand;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * TODO add doc
 */
public class Interpreter {

    // TODO adapt to v1.Interpreter interface
    private Parser parser;

    public Interpreter(Parser parser) {
        this.parser = parser;
    }

    public String interpret(String state, String commands) throws InterpreterException {
        // Parse commands:
        List<ExecutionCommand> commandList;
        try {
            commandList = parseCommands(commands);
        } catch (ParserError pe) {
            pe.printStackTrace();
            throw new InterpreterException("ParserError was occured");
        }

        // Async interpretation:
        String newState = branchInterpretation(state, commandList);

        return newState;
    }

    /**
     * Uses Parser to parse String commands.
     *
     * @param commands text of commands.
     * @return list of ExecutionCommand objects.
     *
     * @throws ParserError when Parser can't parse text of commands.
     *
     * @see ExecutionCommand
     * @see ParserError
     * */
    private List<ExecutionCommand> parseCommands(String commands) throws ParserError {
        if (parser == null) {
            throw new NullPointerException("parser is null");
        }

        return parser.parse(commands);
    }

    /**
     * Turns interpretation process to async branched way.
     *
     * @param state start state of DPS script.
     * @param commands list of commands, which execution will be branched.
     * @return result state after execution of all branches.
     *
     * @see ExecutionCommand
     * */
    private String branchInterpretation(String state, List<ExecutionCommand> commands) {

        // TODO replace with parallel

        return state;
    }

}
