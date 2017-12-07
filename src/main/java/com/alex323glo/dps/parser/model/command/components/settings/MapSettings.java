package com.alex323glo.dps.parser.model.command.components.settings;

import java.util.HashMap;
import java.util.Map;

/**
 * DPS Command Settings implementation. Based on storing and mapping
 * data in DPS Command Settings object using Maps (Java Collection).
 *
 * @author alex323glo
 * @version 1.0.0
 *
 * @see Settings
 * @see Map
 */
public class MapSettings implements Settings {

    private Map<String, Object> settingsMap;

    /**
     * Constructor.
     */
    public MapSettings() {
        settingsMap = new HashMap<>();
    }

    /**
     * Initial constructor.
     *
     * @param settingsMap initial field value.
     *
     * @see Map
     */
    public MapSettings(Map<String, Object> settingsMap) {
        this.settingsMap = settingsMap;
    }

    /**
     * Gets (using mapping) data from current DPS Command Settings object.
     *
     * @param key unique identifier of needed peace of data.
     * @return peace of DPS Command Settings data, stored by key, or null if no
     * data stored in current DPS Command Settings object by such key.
     */
    @Override
    public Object get(String key) {

        if (key == null) {
            throw new NullPointerException("key is null");
        }

        return settingsMap.get(key);
    }

    /**
     * Sets (using mapping) data to current DPS Command Settings object.
     *
     * @param key   unique identifier of needed peace of data.
     * @param value peace of data, which we want to put to current
     *              DPS Command Settings object.
     * @return peace of DPS Command Settings data, stored by this key before, or
     * null if no DPS Command Settings data stored by this key.
     */
    @Override
    public Object put(String key, Object value) {

        if (key == null) {
            throw new NullPointerException("key is null");
        }

        return settingsMap.put(key, value);
    }
}
