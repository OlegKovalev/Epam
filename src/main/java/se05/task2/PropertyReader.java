package se05.task2;

import se05.task2.exception.MissingKeyException;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

public class PropertyReader {

    private ResourceBundle bundle;

    public PropertyReader(String path) throws FileNotFoundException {
        try {
            bundle = ResourceBundle.getBundle(path, Locale.getDefault());
        } catch (MissingResourceException exc) {
            throw new FileNotFoundException("*.properties file not found!");
        }
    }

    public Set<String> getKeys() throws MissingKeyException {
        Set<String> setOfProperties = bundle.keySet();
        if (setOfProperties.size() == 0) {
            throw new MissingKeyException("No any keys here=(");
        }
        return setOfProperties;
    }

    public String getValue(String key) throws MissingKeyException {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException exc) {
            throw new MissingKeyException("Key not found!");
        }
    }
}
