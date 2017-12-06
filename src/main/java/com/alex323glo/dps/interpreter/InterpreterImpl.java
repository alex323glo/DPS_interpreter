package com.alex323glo.dps.interpreter;

import com.alex323glo.dps.interpreter.exception.InterpreterException;
import com.alex323glo.dps.interpreter.model.config.Config;
import com.alex323glo.dps.interpreter.model.config.DefaultConfig;
import com.alex323glo.dps.parser.CommandParser;
import com.alex323glo.dps.parser.exception.ParserException;
import com.alex323glo.dps.parser.model.command.Command;
import com.alex323glo.dps.interpreter.model.state.State;

import java.util.List;

/**
 * Implementation of Interpreter interface. Uses CommandParser to
 * parse DPS Commands from String representation.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see Interpreter
 * @see CommandParser
 */
public class InterpreterImpl implements Interpreter {

    // TODO fix DEFAULT_CONFIG field
    private static final Config DEFAULT_CONFIG = new DefaultConfig();

    private CommandParser commandParser;

    /**
     * Initial constructor.
     *
     * @param commandParser initial field value.
     *
     * @see CommandParser
     * */
    public InterpreterImpl(CommandParser commandParser) {
        this.commandParser = commandParser;
    }

    /**
     * Interprets (executes) DPS Commands on initial DPS State.
     * Uses CommandParser to parse (from String) DPS Commands before execution.<br>
     *
     * Uses branchInterpretation() method to turn DPS Commands interpretation process to
     * parallel (branched) way.
     *
     * @param state       initial DPS (script) State.
     * @param commandsStr String representation of DPS Commands, which will be interpreted (executed).
     * @return new DPS (script) State, safe for old State (doesn't change old object and creates new one).
     * @throws ParserException      when in some reasons can't parse DPS Commands (from String to
     *                              List of Command class objects).
     * @throws InterpreterException when in some reasons can't interpret (execute) parsed DPS Commands
     *                              on initial DPS (script) State.
     *
     * @see InterpreterImpl#branchInterpretation(State, List)
     * @see State
     * @see ParserException
     * @see InterpreterException
     */
    @Override
    public State interpret(State state, String commandsStr) throws ParserException, InterpreterException {
        if (state == null || commandsStr == null) {
            throw new NullPointerException("state or commandStr is null");
        }

        List<Command> commandList = parseCommands(commandsStr);   // throws ParserException !

        State resultState = branchInterpretation(state, commandList);   // throws InterpreterException !

        if (resultState == null) {
            throw new InterpreterException(
                    String.format("can't interpret commands (%s) on initial state (%s)", commandsStr, state));
        }

        return resultState;
    }

    /**
     * Uses CommandParser to parse String commands to List of Command class objects.
     *
     * @param commands String representation of group of commands.
     * @return List of Command class objects.
     *
     * @throws ParserException when Parser can't parse group of commands from
     * String to List of Command class objects.
     *
     * @see Command
     * @see List
     * @see ParserException
     * */
    private List<Command> parseCommands(String commands) throws ParserException {

        List<Command> commandList = commandParser.parse(commands);   // throws ParserException !

        if (commandList == null || commandList.size() < 1) {
            throw new ParserException("commandList is null, empty or was not created during parsing)");
        }

        return commandList;
    }

    /**
     * Turns interpretation process (execution of DPS Commands on DPS State)
     * to parallel (branched) process. <br>
     *
     * Uses executeBranch() method to invoke
     * execution of each branch (one branch for one command).
     *
     * @param state start state of DPS script.
     * @param commands list of commands, which execution will be branched.
     * @return result state after execution of all branches (commands).
     *
     * @see InterpreterImpl#executeBranch(State, Command)
     * @see Command
     * @see State
     * */
    private State branchInterpretation(State state, List<Command> commands) throws InterpreterException {

        if (state == null || commands == null) {
            throw new NullPointerException("state or commands is null");
        }

        State oldState = state;

        // TODO replace with parallel
        for (Command command: commands) {
            state = executeBranch(state, command);  // throws InterpreterException !
        }

        return state;
    }

    /**
     * Executes single DPS Command on initial DPS State as
     * parallel thread function.
     *
     * @param state initial DPS State.
     * @param command DPS Command, which will be executed.
     * @return new DPS State (safe for old DPS State), created after DPS Command execution.
     * @throws InterpreterException when in some reasons DPS Command can't be executed and/or
     * new DPS State can't be created.
     *
     * @see Command
     * @see State
     * @see InterpreterException
     */
    private State executeBranch(State state, Command command) throws InterpreterException {

        if (state == null || command == null) {
            throw new NullPointerException("state or command is null");
        }

        // TODO replace DEFAULT_CONFIG with real config
        State resultState = command.execute(state, DEFAULT_CONFIG);

        if (resultState == null) {
            throw new InterpreterException(
                    String.format("can't execute command (%s) on state (%s)", command, state));
        }

        return resultState;
    }
}
