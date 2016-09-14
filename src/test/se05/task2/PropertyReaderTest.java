package se05.task2;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class PropertyReaderTest {
    PropertyReader propReader;

    @Before
    public void setUp() throws Exception {
        propReader = new PropertyReader("se05.task2.propertyReader");
    }

    @Test
    public void getKeys() throws Exception {
        Set<String> setOfProperties = propReader.getKeys();
        assertEquals(9, setOfProperties.size());
//        setOfProperties.forEach(System.out::println);
    }

    @Test
    public void getValue() throws Exception {
        assertEquals("value3",propReader.getValue("key3"));
    }

}