package se07.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PropertyReaderExecutor {

    private static volatile PropertyReaderExecutor instance;
    private Map<String, String> properties;

    private PropertyReaderExecutor(String path) {
        properties = new HashMap<>();
        ResourceBundle bundle = ResourceBundle.getBundle(path);
       
        for (String key : bundle.keySet()) {
            properties.put(key, bundle.getString(key));
        }
    }

    public static PropertyReaderExecutor getInstance(String path) {
        if (instance == null) {
            synchronized (PropertyReaderExecutor.class) {
                if (instance == null) {
                    instance = new PropertyReaderExecutor(path);
                }
            }
        }
        return instance;
    }
    
    public String getValue(String key) {
        return properties.get(key); 
    }
}
