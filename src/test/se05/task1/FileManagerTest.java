package se05.task1;

import main.java.se05.task1.FileManager;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Oleg on 01.09.2016.
 */
public class FileManagerTest {
        FileManager fileManager;
    
    @Before
    public void setUp() throws Exception {
        fileManager = new FileManager("O:\\test");
    }

    @Test
    public void go() throws Exception {
        fileManager.go();
        
    }

}