package com.alex323glo.dps.parser;

import com.alex323glo.dps.parser.exception.ParserException;
import com.alex323glo.dps.parser.model.command.Command;

import java.util.List;

/**
 * Interface for DPS Commands Parser, valuable for DPS Interpreter.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see com.alex323glo.dps.interpreter.Interpreter
 */
public interface CommandParser {

    /**
     * Parses String representation of group of DPS Commands to
     * List of valuable for DPS Interpreter commands.
     *
     * @param commandStr string of commands which will be parsed.
     * @return List of parsed DPS Commands (Command class objects).
     * @throws ParserException when has some problems with converting
     * String of commands to List of objects (Command class objects).
     *
     * @see Command
     * @see List
     * @see ParserException
     * @see com.alex323glo.dps.interpreter.Interpreter
     */
    List<Command> parse(String commandStr) throws ParserException;

}
