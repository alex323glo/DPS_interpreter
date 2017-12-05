package com.alex323glo.dps.interpreter;

import com.alex323glo.dps.interpreter.exception.InterpreterException;
import com.alex323glo.dps.parser.CommandParser;
import com.alex323glo.dps.parser.exception.ParserException;
import com.alex323glo.dps.parser.model.command.Command;
import com.alex323glo.dps.interpreter.model.state.State;
import com.dima.dps.parser.Parser;
import com.dima.dps.parser.exceptions.ParserError;
import com.dima.dps.parser.parser_commands.ExecutionCommand;

import java.util.List;

/**
 * TODO add doc
 */
public class InterpreterImpl implements Interpreter {

    // TODO adapt to v1.Interpreter interface
    private CommandParser commandParser;

    public InterpreterImpl(CommandParser commandParser) {
        this.commandParser = commandParser;
    }

//    public String interpret(String state, String commands) throws InterpreterException {
//        // Parse commands:
//        List<ExecutionCommand> commandList;
//        try {
//            commandList = parseCommands(commands);
//        } catch (ParserError pe) {
//            pe.printStackTrace();
//            throw new InterpreterException("ParserError was occured");
//        }
//
//        // Async interpretation:
//        String newState = branchInterpretation(state, commandList);
//
//        return newState;
//    }

    /**
     * Uses Parser to parse String commands.
     *
     * @param commands text of commands.
     * @return list of Command objects.
     *
     * @throws ParserException when Parser can't parse text of commands.
     *
     * @see ExecutionCommand
     * @see ParserError
     * */
    private List<Command> parseCommands(String commands) throws ParserException {

        List<Command> commandList = commandParser.parse(commands);   // throws ParserException !

        if (commandList == null || commandList.size() < 1) {
            throw new ParserException("commandList is null, empty or was not created during parsing)");
        }

        return commandList;
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

    @Override
    public State interpret(State state, String commandsStr) throws ParserException, InterpreterException {
        if (state == null || commandsStr == null) {
            throw new NullPointerException("state or commandStr is null");
        }

        List<Command> commandList = parseCommands(commandsStr);   // throws ParserException

        return null;
    }
}
