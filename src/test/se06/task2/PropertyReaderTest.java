package se06.task2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyReaderTest {
    
    PropertyReader reader;
    
    @Before
    public void setUp() throws Exception {
        reader = new PropertyReader("se05.task2.propertyReader");
    }

    @Test
    public void getKeys() throws Exception {
        assertEquals(9, reader.getKeys().size());
    }

    @Test
    public void getValues() throws Exception {
        assertEquals(9, reader.getValues().size());
    }

    @Test
    public void getValue() throws Exception {
        assertEquals("value7", reader.getValue("key7"));
    }

}