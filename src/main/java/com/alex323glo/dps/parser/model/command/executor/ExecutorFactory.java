package com.alex323glo.dps.parser.model.command.executor;

/**
 * Abstract factory of Executor objects.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see Executor
 */
public abstract class ExecutorFactory {

    /**
     * Creates new instance of Executor.
     *
     * @return new Executor object.
     *
     * @see Executor
     * */
    public abstract Executor create();

}
