package com.alex323glo.dps.interpreter.model.command;

import com.alex323glo.dps.interpreter.model.command.components.Settings;
import com.alex323glo.dps.interpreter.model.config.Config;
import com.alex323glo.dps.interpreter.model.state.State;
import org.json.JSONObject;

/**
 * TODO add doc
 */
public interface Command {

    // TODO finish
    State execute(Command command, State state, Config config);
    Settings getSettings();

}
