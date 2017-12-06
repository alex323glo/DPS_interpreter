package com.alex323glo.dps.parser.model.command.executor;

import java.util.HashMap;
import java.util.Map;

/**
 * Executor objects holder (Singleton).
 *
 * @author alex323glo
 * @version 1.0.0
 */
public class ExecutorFactoryHolder {

    /**
     * Ref to singleton instance.
     * */
    private static ExecutorFactoryHolder singleton;

    private Map<String, ExecutorFactory> executorFactoryMap;

    /**
     * Constructor.
     * */
    private ExecutorFactoryHolder() {
        this.executorFactoryMap = new HashMap<>();
    }

    /**
     * Gets ExecutorFactory object from object holder.
     *
     * @param executorClassName key of needed ExecutorFactory object.
     * @return ref to needed ExecutorFactory of null, if no
     * ExecutorFactory with such key.
     *
     * @see ExecutorFactory
     * */
    public ExecutorFactory getFactory(String executorClassName) {
        if (executorClassName == null) {
            throw new NullPointerException("executorClassName is null");
        }

        return executorFactoryMap.get(executorClassName);
    }

    /**
     * Gets object holder's map.
     *
     * @return map, where keys - Executors' names and values - ExecutorFactory objects.
     * */
    public Map<String, ExecutorFactory> getWholeMap() {
        return executorFactoryMap;
    }

    /**
     * Puts new ExecutorFactory object to object holder.
     *
     * @param executorClassName key of ExecutorFactory object.
     * @param factory ExecutorFactory object.
     * @return old ExecutorFactory object from object holder with such key,
     * or null, if object holder doesn't contain object with such key.
     *
     * @see ExecutorFactory
     */
    public ExecutorFactory addFactory(String executorClassName, ExecutorFactory factory) {

        if (executorClassName == null) {
            throw new NullPointerException("executorClassName is null");
        }

        return executorFactoryMap.put(executorClassName, factory);
    }

    /**
     * Gives access to singleton - single-exemplar object of this class.
     *
     * @return ref to singleton object of current class.
     *
     * @see ExecutorFactoryHolder#singleton
     * */
    public static ExecutorFactoryHolder getInstance() {
        if (singleton == null) {
            singleton = new ExecutorFactoryHolder();
        }

        return singleton;
    }
}
