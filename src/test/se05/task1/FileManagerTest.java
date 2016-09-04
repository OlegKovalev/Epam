package se05.task1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Oleg on 01.09.2016.
 */
public class FileManagerTest {
        FileManager fileManager;
    
    @Before
    public void setUp() throws Exception {
        fileManager = new FileManager("O:\\");
    }

    @Test
    public void go() throws Exception {
        fileManager.go();
        
    }

}