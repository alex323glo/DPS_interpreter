package com.alex323glo.dps.parser;

import com.alex323glo.dps.interpreter.Interpreter;
import com.alex323glo.dps.parser.exception.ParserException;
import com.alex323glo.dps.parser.model.command.Command;
import com.alex323glo.dps.parser.model.command.components.settings.MapSettings;
import com.alex323glo.dps.parser.model.command.executor.ExecutorFactoryHolder;
import com.alex323glo.dps.parser.model.command.executor.Executor;
import com.alex323glo.dps.parser.model.command.executor.ExecutorFactory;
import com.dima.dps.parser.Parser;
import com.dima.dps.parser.exceptions.ParserError;
import com.dima.dps.parser.parser_commands.ExecutionCommand;
import com.dima.dps.parser.parser_commands.SyntaxCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CommandParser interface. Uses Parser class
 * from another module (package com.dima.dps.parser).
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see CommandParser
 * @see Parser
 */
public class CommandParserImpl implements CommandParser {

    private Parser parser;

    /**
     * Initial constructor. Helps to configure parser
     * with DPS commands' syntax.
     *
     * @param syntaxCommandList initial field value.
     *
     * @see SyntaxCommand
     * @see List
     * */
    public CommandParserImpl(List<SyntaxCommand> syntaxCommandList) {
        if (syntaxCommandList == null) {
            throw new NullPointerException("syntaxCommandList is null");
        }

        parser = new Parser(new ArrayList<>(syntaxCommandList));
    }

    /**
     * Parses String representation of group of DPS Commands to
     * List of valuable for DPS Interpreter commands.
     * <br>
     * Uses constructCommands() method to create List of Commands (Command class instances)
     * from List of ExecutionCommand objects.
     *
     * @param commandStr string of commands which will be parsed.
     * @return List of parsed DPS Commands (Command class objects).
     * @throws ParserException when has some problems with converting
     *                         String of commands to List of objects (Command class objects).
     *
     * @see CommandParserImpl#constructCommands(List)
     * @see Command
     * @see List
     * @see ParserException
     * @see Interpreter
     *
     */
    @Override
    public List<Command> parse(String commandStr) throws ParserException {

        if (commandStr == null) {
            throw new NullPointerException("commandStr is null");
        }

        List<ExecutionCommand> executionCommandList;

        try {
            executionCommandList = parser.parse(commandStr);
        } catch (ParserError parserError) {
            parserError.printStackTrace();
            throw new ParserException(String.format("was caught ParserError (%s)", parserError.getMessage()));
        }

        return constructCommands(executionCommandList); // throws ParserException !
    }

    /**
     * Takes List of ExecutionCommand objects and creates from it
     * new List of Commands (for Interpreter).
     * Uses wrapExecutionCommand() method to generate Command object of ExecutionCommand object.
     *
     * @param executionCommands list of ExecutionCommands.
     * @return new List of Commands (for interpreter).
     *
     * @see CommandParserImpl#wrapExecutionCommand(ExecutionCommand)
     * @see Command
     * @see ExecutionCommand
     * @see List
     */
    private List<Command> constructCommands(List<ExecutionCommand> executionCommands) throws ParserException {

        if (executionCommands == null) {
            throw new NullPointerException("executionCommands is null");
        }

        List<Command> resultCommandList = new ArrayList<>(executionCommands.size());

        for (ExecutionCommand executionCommand: executionCommands) {
            resultCommandList.add(wrapExecutionCommand(executionCommand));
        }

        return resultCommandList;
    }

    /**
     * Creates Command class instance of ExecutionCommand object using
     * ExecutorFactory to create Executor of Command and ExecutorFactoryHolder (singleton)
     * to find needed ExecutorFactory instance.
     *
     * @param executionCommand object, which is used to create new Command class instance.
     * @return new instance of Command class.
     * @throws ParserException when can't find needed ExecutorFactory or when can't create new Executor
     * object using this ExecutorFactory.
     *
     * @see ExecutionCommand
     * @see Command
     * @see ParserException
     * @see Executor
     * @see ExecutorFactory
     * @see ExecutorFactoryHolder
     */
    private Command wrapExecutionCommand(ExecutionCommand executionCommand) throws ParserException {
        ExecutorFactoryHolder factoryHolder = ExecutorFactoryHolder.getInstance();
        ExecutorFactory executorFactory =
                factoryHolder.getFactory(executionCommand.getSyntaxCommand().getClass().getName());

        if (executorFactory == null) {
            throw new ParserException(String.format(
                    "tempExecutorFactory is null (can't find needed ExecutorFactory by key (%s)",
                    executionCommand.getSyntaxCommand().getClass().getName())
            );
        }

        Executor executor = executorFactory.create();

        if (executor == null) {
            throw new ParserException("tempExecutor is null (ExecutorFactory can't create instance of Executor)");
        }

        return new Command(executionCommand, executor, new MapSettings(executionCommand.getParams().toMap()));
    }
}
