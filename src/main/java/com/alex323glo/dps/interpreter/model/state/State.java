package com.alex323glo.dps.interpreter.model.state;

import com.alex323glo.dps.interpreter.model.state.structured.components.Head;

import java.io.Serializable;

/**
 * DPS State interface. Defines signatures for methods
 * for data mapping in DPS State object.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see Head
 */
public interface State extends Serializable {

    /**
     * Gets (using mapping) data from current DPS State object.
     *
     * @param key unique identifier of needed peace of data.
     * @return peace of DPS State data, stored by key, or null if no
     * data stored in current DPS State object by such key.
     *
     * @see StateData
     */
    StateData get(String key);

    /**
     * Sets (using mapping) data to current DPS State object.
     *
     * @param key unique identifier of needed peace of data.
     * @param value peace of data, which we want to put to current
     *              DPS State object.
     * @return peace of DPS State data, stored by this key before, or
     * null if no data stored by this key.
     *
     * @see StateData
     */
    StateData put(String key, StateData value);

    /**
     * Creates new object of DPS State which is a deep copy of
     * current DPS State object.
     *
     * @return deep copy of current DPS State object.
     */
    State deepCopy();

}
