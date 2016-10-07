package se07.task2;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;


public class PropertyReaderThreadTest {

    private static final String PATH = "se07.task2.PropertyReaderExecutor";
    private static final int THREAD_COUNT = 3;
    private ExecutorService executorService;

    @Before
    public void setUp() throws Exception {
        executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    @Test
    public void call() throws Exception {
        Future<String> thread1 = executorService.submit(new PropertyReaderThread(PATH, "key1"));
        Future<String> thread2 = executorService.submit(new PropertyReaderThread(PATH, "key2"));
        Future<String> thread3 = executorService.submit(new PropertyReaderThread(PATH, "key3"));

        assertEquals("value1", thread1.get());
        assertEquals("value2", thread2.get());
        assertEquals("value3", thread3.get());
    }
}