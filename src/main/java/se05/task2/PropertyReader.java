package se05.task2;

import java.util.*;

public class PropertyReader {

    private ResourceBundle bundle;

    public PropertyReader(String path) {
        try {
            bundle = ResourceBundle.getBundle(path, Locale.getDefault());
        } catch (MissingResourceException exc) {
            throw new RuntimeException("*.properties file not found!");
        }
    }

    public Set<String> getKeys() {
        Set<String> setOfProperties = bundle.keySet();
        if (setOfProperties.size() == 0) {
            throw new NullPointerException("No any keys here=(");
        }
        return setOfProperties;
    }

    public String getValue(String key) {
        try {
            return bundle.getString(key);
        } catch (NullPointerException exc) {
            throw new NullPointerException("Key not found!");
        }
    }
}
