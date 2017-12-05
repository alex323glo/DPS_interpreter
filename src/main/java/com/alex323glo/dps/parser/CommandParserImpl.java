package com.alex323glo.dps.parser;

import com.alex323glo.dps.parser.model.command.Command;
import com.dima.dps.parser.Parser;
import com.dima.dps.parser.parser_commands.SyntaxCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO add doc
 */
public class CommandParserImpl implements CommandParser {

    private Parser parser;

    public CommandParserImpl(List<SyntaxCommand> syntaxCommandList) {
        if (syntaxCommandList == null) {
            throw new NullPointerException("syntaxCommandList is null");
        }

        parser = new Parser(new ArrayList<>(syntaxCommandList));
    }

    @Override
    public List<Command> parse(String commandStr) {

        if (commandStr == null) {
            throw new NullPointerException("commandStr is null");
        }



        return null;
    }
}
