package com.alex323glo.dps.interpreter.model.state;

import com.alex323glo.dps.interpreter.model.state.components.Head;
import com.alex323glo.dps.interpreter.model.state.components.Storage;
import com.alex323glo.dps.interpreter.model.state.components.Locale;
import com.alex323glo.dps.interpreter.model.state.components.Lib;

import java.io.Serializable;

/**
 * DPS State model class.
 * Aggregates Head class instance.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see Head
 */
public class State implements Serializable {

    // TODO finish
    private Head head;
    private Storage storage;
    private Locale locale;
    private Lib lib;

}
