package com.alex323glo.dps.interpreter.model.state;

import java.io.Serializable;

/**
 * Model of DPS State data, which aggregates actual data (data field)
 * and its type (type field).
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see State
 * @see Serializable
 */
public class StateData implements Serializable {

    private Class type;
    private Object data;

    /**
     * Constructor.
     * */
    public StateData() {
    }

    /**
     * Initial constructor.
     *
     * @param type initial field value.
     * @param data initial field value.
     */
    public StateData(Class type, Object data) {
        this.type = type;
        this.data = data;
    }

    /**
     * Type field getter.
     *
     * @return field value.
     */
    public Class getType() {
        return type;
    }

    /**
     * Type field setter.
     *
     * @param type initial field value.
     */
    public void setType(Class type) {
        this.type = type;
    }

    /**
     * Data field getter.
     *
     * @return field value.
     */
    public Object getData() {
        return data;
    }

    /**
     * Data field setter.
     *
     * @param data initial field value.
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Represents current object as String text.
     *
     * @return String representation of current object's state.
     * */
    @Override
    public String toString() {
        return "StatePart{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }
}
