package com.alex323glo.dps.parser.model.command.executor;

import com.alex323glo.dps.interpreter.exception.ExecutionException;
import com.alex323glo.dps.interpreter.model.config.Config;
import com.alex323glo.dps.interpreter.model.state.State;
import com.alex323glo.dps.parser.model.command.Command;

/**
 * Executor of DPS Command script (Command design pattern). Represents
 * logic of DPS Command execution as entity (class).
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see Command
 * */
public interface Executor {

    /**
     * Executes needed action on Command object.
     *
     * @param command invoker (holder) of current Executor instance.
     * @param state initial state of DPS (script).
     * @param config configurations of Command execution.
     * @return new instance of State (result state of DPS after execution of
     * DPS Command).
     *
     * @see Command
     * @see State
     * @see Config
     * */
    State execute(Command command, State state, Config config) throws ExecutionException;

}
