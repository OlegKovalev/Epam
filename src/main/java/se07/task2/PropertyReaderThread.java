package se07.task2;

import java.util.concurrent.Callable;

public class PropertyReaderThread implements Callable<String> {

    private String path, key;

    public PropertyReaderThread(String path, String key) {
        this.path = path;
        this.key = key;
    }

    @Override
    public String call() {
        PropertyReaderExecutor reader = PropertyReaderExecutor.getInstance(path);
        return reader.getValue(key);
    }
}
