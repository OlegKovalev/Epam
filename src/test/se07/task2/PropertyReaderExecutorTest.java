package se07.task2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleg on 24.09.2016.
 */
public class PropertyReaderExecutorTest {

    public static final int THREAD_COUNT = 3;
    public static final String PATH = "src\\main\\resources\\se07\\task2\\propertyReader";
    Thread[] threads;

    @Before
    public void setUp() throws Exception {
        threads = new Thread[THREAD_COUNT];
    }

    @Test
    public void getInstance() throws Exception {
        for (int i = 0; i < THREAD_COUNT; i++) {
            
           /* final int constI = i;
            threads[i] = new Thread(() -> {
                PropertyReaderExecutor reader = PropertyReaderExecutor.getInstance(PATH);
                String key = "key" + (constI + 1);
                String value = reader.getValue(key);

                assertEquals("value" + (constI + 1), value);
            });*/
        }
    }

    @Test
    public void getValue() throws Exception {

    }

}