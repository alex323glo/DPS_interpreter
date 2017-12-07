package com.alex323glo.dps.interpreter.model.state.map;

import com.alex323glo.dps.interpreter.model.state.State;
import com.alex323glo.dps.interpreter.model.state.StateData;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * DPS State implementation. Based on storing and mapping
 * data in DPS State object using Maps (Java Collection).
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see State
 * @see Map
 */
public class MapState implements State {

    private Map<String, StateData> stateDataMap;

    /**
     * Constructor.
     * */
    public MapState() {
        stateDataMap = new HashMap<>();
    }

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

        if (key == null) {
            throw new NullPointerException("key is null");
        }

        return stateDataMap.get(key);
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

        if (key == null) {
            throw new NullPointerException("key is null");
        }

        return stateDataMap.put(key, value);
    }

    /**
     * Creates new object of DPS State which is a deep copy of
     * current DPS State object.
     *
     * @return deep copy of current DPS State object.
     */
    @Override
    public MapState deepCopy() {

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            MapState thisCopy = (MapState) ois.readObject();

            return thisCopy;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Represents current object as String text.
     *
     * @return String representation of current object's state.
     * */
    @Override
    public String toString() {
        return "MapState{" +
                "stateDataMap=" + stateDataMap +
                '}';
    }
}
