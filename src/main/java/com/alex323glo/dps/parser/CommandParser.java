package com.alex323glo.dps.parser;

import com.alex323glo.dps.parser.model.command.Command;

import java.util.List;

/**
 * Created by alex323glo on 05.12.17.
 */
public interface CommandParser {

    List<Command> parse(String commandStr);

}
