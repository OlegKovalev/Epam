package se06.task2;

import java.util.*;

public class PropertyReader {
    private Map<String, String> resource;

    public PropertyReader(String path) {
        loadResource(path);
    }

    public Set<String> getKeys() {
        return resource.keySet();
    }

    public Collection<String> getValues() {
        return resource.values();
    }

    public String getValue(String key) {
        return resource.get(key);
    }

    private void loadResource(String path) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(path);
            resource = new HashMap<>();

            for (String key : bundle.keySet()) {
                resource.put(key, bundle.getString(key));
            }
        } catch (RuntimeException exc) {
            exc.printStackTrace();
        }
    }
}
