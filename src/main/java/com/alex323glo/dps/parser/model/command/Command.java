package com.alex323glo.dps.parser.model.command;

import com.alex323glo.dps.parser.model.command.components.Settings;
import com.alex323glo.dps.interpreter.model.config.Config;
import com.alex323glo.dps.interpreter.model.state.State;
import com.dima.dps.parser.parser_commands.ExecutionCommand;
import org.json.JSONObject;

/**
 * TODO add doc
 */
public abstract class Command {

    private ExecutionCommand executionCommand;

    // TODO finish
    public abstract State execute(Command command, State state, Config config);

    public JSONObject getParamsJSON() {
        return executionCommand.getParams();
    }

    public void setParamsJSON(JSONObject paramsJSON) {
        if (paramsJSON == null) {
            throw new NullPointerException("paramsJSON is null");
        }

        executionCommand.setParams(paramsJSON);
    }

    /**
     * Settings property getter.
     *
     * @return value of settings property
     *
     * @throws UnsupportedOperationException must be override if needed!
     *
     * @see Settings
     */
    public Settings getSettings() {
        throw new UnsupportedOperationException("this operation is not defined yet");
    }

    /**
     * Settings property setter.
     *
     * @param settings initial value of settings property
     *
     * @throws UnsupportedOperationException must be override if needed!
     *
     * @see Settings
     */
    public void setSettings(Settings settings) {
        throw new UnsupportedOperationException("this operation is not defined yet");
    }

}
