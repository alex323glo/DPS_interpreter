package com.alex323glo.dps.parser.model.command.components.settings;

/**
 * DPS Command Settings interface. Defines signatures for methods
 * for data mapping in DPS Command Settings object.
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see com.alex323glo.dps.parser.model.command.Command
 */
public interface Settings {

    /**
     * Gets (using mapping) data from current DPS Command Settings object.
     *
     * @param key unique identifier of needed peace of data.
     * @return peace of DPS Command Settings data, stored by key, or null if no
     * data stored in current DPS Command Settings object by such key.
     */
    Object get(String key);

    /**
     * Sets (using mapping) data to current DPS Command Settings object.
     *
     * @param key unique identifier of needed peace of data.
     * @param value peace of data, which we want to put to current
     *              DPS Command Settings object.
     * @return peace of DPS Command Settings data, stored by this key before, or
     * null if no DPS Command Settings data stored by this key.
     */
    Object put(String key, Object value);

}
