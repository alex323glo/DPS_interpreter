package com.alex323glo.dps.interpreter.model.state.structured;

import com.alex323glo.dps.interpreter.model.state.State;
import com.alex323glo.dps.interpreter.model.state.StateData;
import com.alex323glo.dps.interpreter.model.state.structured.components.Head;
import com.alex323glo.dps.interpreter.model.state.structured.components.Lib;
import com.alex323glo.dps.interpreter.model.state.structured.components.Locale;
import com.alex323glo.dps.interpreter.model.state.structured.components.Storage;

/**
 * DPS State implementation. Based on structured storing
 * and mapping data in DPS State object.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see State
 */
public class StructuredState implements State {

    // TODO fix logic
    private Head head;
    private Storage storage;
    private Locale locale;
    private Lib lib;

    /**
     * Gets (using mapping) data from current DPS State object.
     *
     * @param key unique identifier of needed peace of data.
     * @return peace of DPS State data, stored by key, or null if no
     * data stored in current DPS State object by such key.
     *
     * @see StateData
     */
    @Override
    public StateData get(String key) {
        // TODO finish implementation
        return null;
    }

    /**
     * Sets (using mapping) data to current DPS State object.
     *
     * @param key   unique identifier of needed peace of data.
     * @param value peace of data, which we want to put to current
     *              DPS State object.
     * @return peace of DPS State data, stored by this key before, or
     * null if no data stored by this key.
     *
     * @see StateData
     */
    @Override
    public StateData put(String key, StateData value) {
        // TODO finish implementation
        return null;
    }

    /**
     * Creates new object of DPS State which is a deep copy of
     * current DPS State object.
     *
     * @return deep copy of current DPS State object.
     */
    @Override
    public State deepCopy() {
        // TODO finish implementation
        return null;
    }
}