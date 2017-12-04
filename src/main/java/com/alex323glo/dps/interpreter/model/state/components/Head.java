package com.alex323glo.dps.interpreter.model.state.components;

import com.alex323glo.dps.interpreter.model.state.State;

import java.io.Serializable;

/**
 * DPS State Head part model.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see State
 * */
public class Head implements Serializable {

    private String type;
    private Data data;

    /**
     * Empty constructor.
     * */
    public Head() {
    }

    /**
     * Assign constructor.
     *
     * @param type initial value
     * @param data initial value
     * */
    public Head(String type, Data data) {
        this.type = type;
        this.data = data;
    }

    /**
     * Type field getter.
     *
     * @return value of field.
     */
    public String getType() {
        return type;
    }

    /**
     * Type field setter.
     *
     * @param type initial value.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Data field getter.
     *
     * @return value of field.
     *
     * @see Data
     */
    public Data getData() {
        return data;
    }

    /**
     * Data field setter.
     *
     * @param data initial value.
     *
     * @see Data
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * Inner DPS State Head Data class.
     *
     * @see Head
     * */
    class Data {

    }
}
