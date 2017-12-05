package com.alex323glo.dps.parser.model.command;

import com.alex323glo.dps.parser.model.command.components.Settings;
import com.alex323glo.dps.interpreter.model.config.Config;
import com.alex323glo.dps.interpreter.model.state.State;

/**
 * TODO add doc
 */
public interface Command {

    // TODO finish
    State execute(Command command, State state, Config config);
    Settings getSettings();

}
