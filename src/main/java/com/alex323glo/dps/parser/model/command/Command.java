package com.alex323glo.dps.parser.model.command;

import com.alex323glo.dps.interpreter.exception.ExecutionException;
import com.alex323glo.dps.parser.model.command.components.settings.Settings;
import com.alex323glo.dps.interpreter.model.config.Config;
import com.alex323glo.dps.interpreter.model.state.State;
import com.alex323glo.dps.parser.model.command.executor.Executor;
import com.dima.dps.parser.parser_commands.ExecutionCommand;
import org.json.JSONObject;

/**
 * Abstraction of interpreted Command.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see com.alex323glo.dps.interpreter.Interpreter
 */
public class Command {

    private ExecutionCommand executionCommand;
    private Executor executor;
    private Settings settings;

    /**
     * Initial constructor.
     *
     * @param executionCommand initial field value.
     * @param executor initial field value.
     *
     * @see ExecutionCommand
     * @see Executor
     * */
    public Command(ExecutionCommand executionCommand, Executor executor, Settings settings) {
        this.executionCommand = executionCommand;
        this.executor = executor;
        this.settings = settings;
    }

    /**
     * Executes current Command.
     *
     * @param state initial state of DPS (script).
     * @param config configurations of Command execution.
     * @return result state of DPS (script).
     *
     * @see State
     * @see Config
     */
    public State execute(State state, Config config) throws ExecutionException {
        if (executor == null || executionCommand == null) {
            throw new NullPointerException("executionCommand or executor is null");
        }

        return executor.execute(this, state, config);   // throw ExecutionException !
    }

    /**
     * Params property getter.
     *
     * @return JSON object, which contains params.
     *
     * @see JSONObject
     * */
    public JSONObject getParamsJSON() {
        return executionCommand.getParams();
    }

    /**
     * Params property setter.
     *
     * @param paramsJSON initial value of property.
     *
     * @see JSONObject
     */
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
     * @see Settings
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * Settings property setter.
     *
     * @param settings initial value of settings property
     *
     * @see Settings
     */
    public void setSettings(Settings settings) {
        if (settings == null) {
            throw new NullPointerException("settings is null");
        }

        this.settings = settings;
    }

}
